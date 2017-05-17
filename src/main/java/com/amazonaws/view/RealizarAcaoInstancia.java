package com.amazonaws.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.model.Imagem;
import com.amazonaws.model.Instancia;
import com.amazonaws.model.InstanciaDAO;
import com.amazonaws.services.appstream.model.Image;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;

public class RealizarAcaoInstancia implements ActionListener {

	private JFrame telaRealizarAcaoInstancia;

	private JLabel lblId;
	private JLabel lblState;
	//private JLabel lblImagem;

	private JLabel lblIdInstancia;
	private JLabel lblImagemInstancia;
	private JLabel lblStateInstancia;

	private JButton btnStart;
	private JButton btnStop;
	private JButton btnTerminate;
	// private JButton btnPause;
	// ListarInstancias listarInstancias = new ListarInstancias();

	private Instancia instancia = new Instancia();

	public RealizarAcaoInstancia() {

		this.telaRealizarAcaoInstancia = new JFrame("Instância criada");
		this.telaRealizarAcaoInstancia.setSize(500, 400);
		this.telaRealizarAcaoInstancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.telaRealizarAcaoInstancia.setLayout(null);
		this.telaRealizarAcaoInstancia.setLocationRelativeTo(null);
		this.telaRealizarAcaoInstancia.setVisible(true);

		this.lblId = new JLabel("ID");
		//this.lblState = new JLabel("Imagem");
		this.lblState = new JLabel("Status");

		this.btnStart = new JButton("Start");
		this.btnStop = new JButton("Stop");
		this.btnTerminate = new JButton("Terminate");
		// this.btnPause = new JButton("Pause");

		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		// btnPause.addActionListener(this);
		btnTerminate.addActionListener(this);

		addComponentes();
		configurarComponentes();
		addEventos();
	}

	private void addComponentes() {

		this.telaRealizarAcaoInstancia.add(this.lblId);
	    //this.telaRealizarAcaoInstancia.add(this.lblImagem);
		this.telaRealizarAcaoInstancia.add(this.lblState);
		// this.telaRealizarAcaoInstancia.add(this.lblStateInstancia);

		this.telaRealizarAcaoInstancia.add(this.btnStart);
		this.telaRealizarAcaoInstancia.add(this.btnStop);
		this.telaRealizarAcaoInstancia.add(this.btnTerminate);
		// this.telaRealizarAcaoInstancia.add(this.btnPause);
	}

	private void configurarComponentes() {
		// this.lblSimbolo.setBounds(20, 20, 180, 30); // x, y, largura, altura

		this.lblId.setBounds(20, 100, 180, 30);
		this.lblState.setBounds(20, 150, 180, 30);
		//this.lblImagem.setBounds(20, 150, 180, 30);

		this.btnStart.setBounds(10, 250, 140, 30);
		this.btnStop.setBounds(170, 250, 140, 30);
		this.btnTerminate.setBounds(330, 250, 140, 30);
		// this.btnPause.setBounds(520, 400, 140, 30);

		telaRealizarAcaoInstancia.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	}

	private void addEventos() {

	}

	public void actionPerformed(ActionEvent evento) {
		InstanciaDAO instanciaDAO = new InstanciaDAO();

		AWSCredentials credentials = new ProfileCredentialsProvider("cloud").getCredentials();
		AmazonEC2 ec2 = new AmazonEC2Client(credentials);
		ec2.setEndpoint("ec2.us-west-2.amazonaws.com");

		List<String> instanceIds = new LinkedList<String>();
		instanceIds.add(instancia.getId());

		Object o = evento.getSource();

		if (o == this.btnStart) {
			try {
				StartInstancesRequest startIR = new StartInstancesRequest(instanceIds);
				ec2.startInstances(startIR);
				JOptionPane.showMessageDialog(null, "Instância iniciada com sucesso.");
				telaRealizarAcaoInstancia.dispose();
				ListarInstancias listarInstancias = new ListarInstancias();
				listarInstancias.atualizarTabela(instanciaDAO.getInstancia());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao iniciar a instancia - tente novamente mais tarde.");
			}

		}
		if (o == this.btnStop) {
			try {
				StopInstancesRequest stopIR = new StopInstancesRequest(instanceIds);
				ec2.stopInstances(stopIR);
				JOptionPane.showMessageDialog(null, "Instância parada com sucesso.");
				telaRealizarAcaoInstancia.dispose();
				ListarInstancias listarInstancias = new ListarInstancias();
				listarInstancias.atualizarTabela(instanciaDAO.getInstancia());

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao parar a instância - tente novamente mais tarde.");

			}
			StopInstancesRequest stopIR = new StopInstancesRequest(instanceIds);
			ec2.stopInstances(stopIR);

		}
		if (o == this.btnTerminate) {
			// atualizarTabela(instanciaDAO.getInstancia());
			try {
				TerminateInstancesRequest tir = new TerminateInstancesRequest(instanceIds);
				ec2.terminateInstances(tir);
				JOptionPane.showMessageDialog(null, "Intância removida(terminate) com sucesso.");
				telaRealizarAcaoInstancia.dispose();
				ListarInstancias listarInstancias = new ListarInstancias();
				listarInstancias.atualizarTabela(instanciaDAO.getInstancia());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao remover (terminate) a instância - tente novamente mais tarde.");

			}

		}

	}

	public Instancia setarJLabelInstancia(String id, String state) {


		instancia.setId(id);
		instancia.setEstado(state);

		this.lblIdInstancia = new JLabel(instancia.getId());
		this.lblStateInstancia = new JLabel(instancia.getEstado());
		//this.lblImagemInstancia = new JLabel(instancia.getImagem().getDescricao());
		
		
		this.telaRealizarAcaoInstancia.add(this.lblIdInstancia);
		this.telaRealizarAcaoInstancia.add(this.lblStateInstancia);
		//this.telaRealizarAcaoInstancia.add(this.lblImagemInstancia);


		this.lblIdInstancia.setBounds(200, 100, 180, 30);
		this.lblStateInstancia.setBounds(200, 150, 180, 30);
		//this.lblImagemInstancia.setBounds(200, 200, 180, 30);


		return instancia;

	}

}
