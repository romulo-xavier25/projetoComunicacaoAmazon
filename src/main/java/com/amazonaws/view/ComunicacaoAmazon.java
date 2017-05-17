package com.amazonaws.view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.RunInstancesRequest;

public class ComunicacaoAmazon {
	
@SuppressWarnings("deprecation")
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
	}

}
