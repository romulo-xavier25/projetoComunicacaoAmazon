package com.amazonaws.model;

import java.util.ArrayList;
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

public class InstanciaDAO {

	public void criarInstancia() throws Exception {

	}

	public Set<Instance> getInstancia() {

		AWSCredentials credentials = new ProfileCredentialsProvider("cloud").getCredentials();
		AmazonEC2 ec2 = new AmazonEC2Client(credentials);

		ec2.setEndpoint("ec2.us-west-2.amazonaws.com");

		try {
			DescribeInstancesResult describeInstancesRequest = ec2.describeInstances();
			List<Reservation> reservations = describeInstancesRequest.getReservations();
			Set<Instance> instances = new HashSet<Instance>();

			// add all instances to a Set.
			for (Reservation reservation : reservations) {
				instances.addAll(reservation.getInstances());
			}
			if (!instances.isEmpty()) {
				return instances;
			} else {
				JOptionPane.showMessageDialog(null, "Você ainda não criou nenhuma instância.");
				return null;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar as suas instâncias - Tente novamente mais tarde.");
		}

		// System.out.println("You have " + instances.size() + " Amazon EC2
		// instance(s).");
		// for (Instance ins : instances){

		// instance id
		// String instanceId = ins.getInstanceId();

		// instance state
		// InstanceState is = ins.getState();
		// System.out.println(instanceId+" "+is.getName());

		// }
		return null;
	}

	public void startInstancia() {
		System.out.println("botão start pressionado.");

	}

	public void stopInstancia() {
		System.out.println("botão stop pressionado.");

	}

	public void terminateInstancia() {
		System.out.println("botão terminate pressionado.");

	}

	public void pauseInstancia() {
		System.out.println("botão pause pressionado.");

	}

}
