package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ComunicacaoAmazon {

	public static void main(String[] args) {
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
         }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        MensagemBoasVindas msg = new MensagemBoasVindas();
        ListarImagens listarImagens = new ListarImagens();
        RealizarAcaoImagem realizarAcaoImagem = new RealizarAcaoImagem();
	}

}
