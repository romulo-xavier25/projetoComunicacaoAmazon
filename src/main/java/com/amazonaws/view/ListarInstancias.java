package com.amazonaws.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.amazonaws.model.Imagem;
import com.amazonaws.model.ImagemDAO;
import com.amazonaws.model.Instancia;
import com.amazonaws.model.InstanciaDAO;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.util.CriarInstancia;

public class ListarInstancias implements ActionListener, MouseListener {

	private JFrame telaListarInstancias;
	private static DefaultTableModel modelo;
	private JTable table;
	private JScrollPane scrol;
	private JButton btnListar;

	private JLabel lblTitulo;

	CriarInstancia criarInstancia = new CriarInstancia();
	Instancia instancia = new Instancia();

	// List<Imagem> listaImagem = new ArrayList<Imagem>();

	public ListarInstancias() {
		this.telaListarInstancias = new JFrame("Listando as Instâncias");
		this.telaListarInstancias.setSize(1000, 500);
		this.telaListarInstancias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.telaListarInstancias.setLayout(null);
		this.telaListarInstancias.setLocationRelativeTo(null);
		this.telaListarInstancias.setVisible(true);
		this.lblTitulo = new JLabel("Listar Instancias");
		this.btnListar = new JButton("Listar Instancias");

		this.table = new JTable();
		this.scrol = new JScrollPane(table);

		btnListar.addActionListener(this);

		addJTable();
		addComponentes();
		configurarComponentes();
		addEventos();

	}

	private void addComponentes() {
		this.telaListarInstancias.add(this.lblTitulo);
		this.telaListarInstancias.add(this.scrol);
		this.telaListarInstancias.add(this.btnListar);

	}

	private void configurarComponentes() {
		this.lblTitulo.setBounds(20, 10, 200, 30); // x, y, largura, altura
		this.scrol.setBounds(20, 50, 960, 300);
		this.btnListar.setBounds(80, 400, 150, 30);

		telaListarInstancias.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	}

	private void addJTable() {
		table.setAutoscrolls(true);
		String[] colunas = { "ID", "Imagem", "Status" };
		modelo = (DefaultTableModel) (new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int colun) {
				return false;
			}
		});
		modelo.setColumnIdentifiers(colunas);
		modelo.setRowCount(0);
		table.setModel(modelo);
		table.setFillsViewportHeight(false);
	}

	public void atualizarTabela(Set<Instance> listaInstancia) {
		ListarInstancias.modelo.setRowCount(0);
		// Instancia criandoNovaInstancia = new Instancia();
		for (Instance instancia : listaInstancia) {
			String[] dados = new String[3];

			dados[0] = instancia.getInstanceId();
			dados[1] = instancia.getImageId();
			dados[2] = instancia.getState().getName();


			// dados[0] = dados[0].toString();
			// dados[1] = dados[1].toString();

			modelo.addRow(dados);
		}
	}

	private void addEventos() {
		this.btnListar.addMouseListener(this);
		this.table.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		Object o = evento.getSource();
		if (o == this.btnListar) {
			try {
				InstanciaDAO instanciaDAO = new InstanciaDAO();
				atualizarTabela(instanciaDAO.getInstancia());
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {

			Integer linha = this.table.getSelectedRow();

			String id = (String) this.table.getValueAt(linha, 0);
			String state = (String) this.table.getValueAt(linha, 2);

			RealizarAcaoInstancia realizarAcaoInstancia = new RealizarAcaoInstancia();
			Instancia instancia = realizarAcaoInstancia.setarJLabelInstancia(id, state);
			this.telaListarInstancias.dispose();

		}

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
