package com.amazonaws.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceState;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;

public class CriarInstancia {

	public void criarInstancia(String id) {

		try {
			AWSCredentials credentials = new ProfileCredentialsProvider("cloud").getCredentials();
			AmazonEC2 ec2 = new AmazonEC2Client(credentials);

			ec2.setEndpoint("ec2.us-west-2.amazonaws.com");

			RunInstancesRequest runInstancesRequest = new RunInstancesRequest();

			runInstancesRequest.withImageId(id).withInstanceType("t2.micro").withMinCount(1).withMaxCount(1)
					.withKeyName("Ja temos batatas").withSecurityGroups("default");

			ec2.runInstances(runInstancesRequest);

			JOptionPane.showMessageDialog(null, "Instância criada com sucesso.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar a sua instância. Tente mais tarde.");
		}

	}
}
