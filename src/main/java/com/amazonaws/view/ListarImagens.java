package com.amazonaws.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.amazonaws.model.Imagem;
import com.amazonaws.model.ImagemDAO;
import com.amazonaws.model.Instancia;
import com.amazonaws.util.CriarInstancia;

public class ListarImagens implements ActionListener, MouseListener {

	private JFrame telaListarImagens;
	private static DefaultTableModel modelo;
	private JTable table;
	private JScrollPane scrol;
	private JButton btnListar;
	private JButton btnCriarInstancia;
	private JButton btnListarInstancias;

	private JLabel lblTitulo;

	CriarInstancia criarInstancia = new CriarInstancia();
	Instancia instancia = new Instancia();

	// List<Imagem> listaImagem = new ArrayList<Imagem>();

	public ListarImagens() {
		this.telaListarImagens = new JFrame("Listando as Imagens da Amazon");
		this.telaListarImagens.setSize(1000, 500);
		this.telaListarImagens.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.telaListarImagens.setLayout(null);
		this.telaListarImagens.setLocationRelativeTo(null);
		this.telaListarImagens.setVisible(true);
		this.lblTitulo = new JLabel("Listar Imagens");
		this.btnListar = new JButton("Listar Imagens");
		this.btnCriarInstancia = new JButton("Criar Instancia");
		this.btnListarInstancias = new JButton("Listar Instancia");

		this.table = new JTable();
		this.scrol = new JScrollPane(table);

		btnListar.addActionListener(this);
		btnCriarInstancia.addActionListener(this);
		btnListarInstancias.addActionListener(this);

		addJTable();
		addComponentes();
		configurarComponentes();
		addEventos();

	}

	private void addComponentes() {
		this.telaListarImagens.add(this.lblTitulo);
		this.telaListarImagens.add(this.scrol);
		this.telaListarImagens.add(this.btnListar);
		this.telaListarImagens.add(this.btnCriarInstancia);
		this.telaListarImagens.add(this.btnListarInstancias);

	}

	private void configurarComponentes() {
		this.lblTitulo.setBounds(20, 10, 200, 30); // x, y, largura, altura
		this.scrol.setBounds(20, 50, 960, 300);
		this.btnListar.setBounds(200, 400, 150, 30);
		this.btnCriarInstancia.setBounds(400, 400, 150, 30);
		this.btnListarInstancias.setBounds(600, 400, 150, 30);

	}

	private void addJTable() {
		table.setAutoscrolls(true);
		String[] colunas = { "ID", "Descrição", "State", "Arquitetura" };
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

	private void atualizarTabela(List<Imagem> listaImagem) {
		this.modelo.setRowCount(0);

		for (Imagem imagem : listaImagem) {
			Object[] dados = new Object[7];
			dados[0] = imagem.getId();
			dados[1] = imagem.getDescricao();
			dados[2] = imagem.getState();
			dados[3] = imagem.getArquitetura();

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
			ImagemDAO imagemDAO = new ImagemDAO();
			atualizarTabela(imagemDAO.getInstancia());
		}
		if (o == this.btnCriarInstancia) {
			try {
				Integer linha = this.table.getSelectedRow();

				String id = (String) this.table.getValueAt(linha, 0);
				System.out.println(id);

				criarInstancia.criarInstancia(id);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao criar Instancia - Favor listar e selecionar uma imagem.");
			}

		}
		if (o == this.btnListarInstancias) {

			ListarInstancias telaListarInstancias = new ListarInstancias();

		}

	}

	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {

			//Integer linha = this.table.getSelectedRow();

			//String id = (String) this.table.getValueAt(linha, 0);
			//String descricao = (String) this.table.getValueAt(linha, 1);
			//String state = (String) this.table.getValueAt(linha, 2);
			//String arquitetura = (String) this.table.getValueAt(linha, 3);

			// criarInstancia.criarInstancia(id);

			//RealizarAcaoImagem realizarAcaoImagem = new RealizarAcaoImagem();
			//Imagem imagem = realizarAcaoImagem.setarJLabel(id, descricao, state, arquitetura);

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
