package view;

import javax.swing.JOptionPane;

public class MensagemBoasVindas {
	
public MensagemBoasVindas(){
        
        mostrarMensagemBoasVindas();    
    }
    
    private void mostrarMensagemBoasVindas(){
        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao ...");
        ListarImagens listarImagens = new ListarImagens();
    }

}
