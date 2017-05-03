package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RealizarAcaoImagem {
	private JFrame telaRealizarAcaoImagem;
	private JLabel lblSimbolo;
	private JLabel lblNomeAMI;
	private JLabel lblId;
	private JLabel lblSource;
	private JLabel lblOwner;
	private JLabel lblVisibility;
	private JLabel lblStatus;
	private JLabel lblDataCriacao;
    private JButton btnStart;
    private JButton btnStop;
    private JButton btnTerminate;
    private JButton btnPause;
    
    public RealizarAcaoImagem(){
    	this.telaRealizarAcaoImagem = new JFrame("Listando as Imagens da Amazon");
    	this.telaRealizarAcaoImagem.setSize(700, 500);
        this.telaRealizarAcaoImagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.telaRealizarAcaoImagem.setLayout(null);
        this.telaRealizarAcaoImagem.setLocationRelativeTo(null);
        this.telaRealizarAcaoImagem.setVisible(true);
        this.lblSimbolo = new JLabel("#");
        this.lblNomeAMI = new JLabel("Nome da AMI");
        this.lblId = new JLabel("ID");
        this.lblSource = new JLabel("Source");
        this.lblOwner = new JLabel("Owner");
        this.lblVisibility = new JLabel("Visibility");
        this.lblStatus = new JLabel("Status");
        this.lblDataCriacao = new JLabel("Data de Criação");
        this.btnStart = new JButton("Start");
        this.btnStop = new JButton("Stop");
        this.btnTerminate = new JButton("Terminate");
        this.btnPause = new JButton("Pause");
        
        addComponentes();
        configurarComponentes();
        addEventos();
    }
    
    private void addComponentes(){
    	this.telaRealizarAcaoImagem.add(this.lblSimbolo);
    	this.telaRealizarAcaoImagem.add(this.lblNomeAMI);
    	this.telaRealizarAcaoImagem.add(this.lblId);
    	this.telaRealizarAcaoImagem.add(this.lblSource);
    	this.telaRealizarAcaoImagem.add(this.lblOwner);
    	this.telaRealizarAcaoImagem.add(this.lblVisibility);
    	this.telaRealizarAcaoImagem.add(this.lblStatus);
    	this.telaRealizarAcaoImagem.add(this.lblDataCriacao);
    	this.telaRealizarAcaoImagem.add(this.btnStart);
    	this.telaRealizarAcaoImagem.add(this.btnStop);
    	this.telaRealizarAcaoImagem.add(this.btnTerminate);
    	this.telaRealizarAcaoImagem.add(this.btnPause);
    }

    private void configurarComponentes(){
    	this.lblSimbolo.setBounds(20, 20, 180, 30); // x, y, largura, altura
    	this.lblNomeAMI.setBounds(20, 50, 180, 30);
    	this.lblId.setBounds(20, 100, 180, 30);
    	this.lblSource.setBounds(20, 150, 180, 30);
    	this.lblOwner.setBounds(20, 200, 180, 30);
    	this.lblVisibility.setBounds(20, 250, 180, 30);
    	this.lblStatus.setBounds(20, 300, 180, 30);
    	this.lblDataCriacao.setBounds(20, 350, 180, 30);
    	this.btnStart.setBounds(40, 400, 140, 30);
    	this.btnStop.setBounds(200, 400, 140, 30);
    	this.btnTerminate.setBounds(360, 400, 140, 30);
    	this.btnPause.setBounds(520, 400, 140, 30);
    }
    
    private void addEventos(){}
    
    public void setarJLabel(String codigoIMG, String nomeAMI, String id, String source, String owner, String visibility, String status, String dataCriacao){
    	
    }


}
