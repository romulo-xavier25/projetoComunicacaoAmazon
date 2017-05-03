package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Imagem;
import model.ImagemDAO;

public class ListarImagens implements ActionListener, MouseListener{
	
	private JFrame telaListarImagens;
	private static DefaultTableModel modelo;
	private JTable table;
    private JScrollPane scrol;
    private JButton btnListar;
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
        this.table = new JTable();
        this.scrol = new JScrollPane(table);
        
        addJTable();
        addComponentes();
        configurarComponentes();
        addEventos();
        
    }
    
    private void addComponentes(){
    	this.telaListarImagens.add(this.lblTitulo);
    	this.telaListarImagens.add(this.scrol);
    	this.telaListarImagens.add(this.btnListar);
    }

    private void configurarComponentes(){
    	this.lblTitulo.setBounds(20, 10, 200, 30); // x, y, largura, altura
    	this.scrol.setBounds(20, 50, 960, 300);
    	this.btnListar.setBounds(80, 400, 150, 30);
    }
    
    private void addJTable(){
        table.setAutoscrolls(true);
        String[] colunas = {"#", "Nome da AMI", "ID", "Source", "Owner", "Visibility", "Status", "Data de Criação"};
        modelo = (DefaultTableModel) (new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colun){
                return false;
            }
        });        
        modelo.setColumnIdentifiers(colunas);
        modelo.setRowCount(0);
        table.setModel(modelo);
        table.setFillsViewportHeight(false);
    }
    
    private void atualizarTabela(List<Imagem> listaImagem){
    	this.modelo.setRowCount(0); 
        
        for (Imagem imagem : listaImagem){
            Object[] dados = new Object[7];
            dados[0] = imagem.getCodigoSimbolo();
            dados[1] = imagem.getNomeAMI();
            dados[2] = imagem.getId();
            dados[3] = imagem.getSource();
            dados[4] = imagem.getOwner();
            dados[5] = imagem.getVisibility();
            dados[6] = imagem.getStatus();
            dados[7] = imagem.getDataCriacao();
            
            modelo.addRow(dados);
        }
    }
    
    private void addEventos(){
    	this.btnListar.addMouseListener(this);
    	this.table.addMouseListener(this);
    }
    
    @Override
	public void actionPerformed(ActionEvent evento) {
    	Object o = evento.getSource();
    	if(o == this.btnListar){
    		ImagemDAO imagemDAO = new ImagemDAO();
    		atualizarTabela(imagemDAO.getInstancia());
    	}
		
	}
    
    @Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2){
			Integer linha = this.table.getSelectedRow();
			String codigoImagem = (String) this.table.getValueAt(linha, 0);
			String nomeAMI = (String) this.table.getValueAt(linha, 1);
			String id = (String) this.table.getValueAt(linha, 2);
			String source = (String) this.table.getValueAt(linha, 3);
			String owner = (String) this.table.getValueAt(linha, 4);
			String visibility = (String) this.table.getValueAt(linha, 5);
			String status = (String) this.table.getValueAt(linha, 6);
			String dataCriacao = (String) this.table.getValueAt(linha, 7);
			RealizarAcaoImagem realizarAcaoImagem = new RealizarAcaoImagem();
			realizarAcaoImagem.setarJLabel(codigoImagem, nomeAMI, id, source, owner, visibility, status, dataCriacao);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


