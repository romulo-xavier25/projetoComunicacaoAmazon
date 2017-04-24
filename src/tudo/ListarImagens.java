package tudo;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarImagens {
	
	private JFrame telaListarImagens;
	private static DefaultTableModel modelo;
	private JTable table;
    private JScrollPane scrol;
    private JButton btnListar;
    private JButton btnStart;
    private JButton btnStop;
    private JButton btnTerminate;
    private JButton btnPause;
    private JLabel lblTitulo;
    
    public ListarImagens(){
    	this.telaListarImagens = new JFrame("Listando as Imagens da Amazon");
    	this.telaListarImagens.setSize(1000, 500);
        this.telaListarImagens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.telaListarImagens.setLayout(null);
        this.telaListarImagens.setLocationRelativeTo(null);
        this.telaListarImagens.setVisible(true);
        this.lblTitulo = new JLabel("Listar Imagens");
        this.btnListar = new JButton("Listar");
        this.btnStart = new JButton("Start");
        this.btnStop = new JButton("Stop");
        this.btnTerminate = new JButton("Terminate");
        this.btnPause = new JButton("Pause");
        this.table = new JTable();
        this.scrol = new JScrollPane(table);
    }

    

}


