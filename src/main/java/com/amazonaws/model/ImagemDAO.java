package com.amazonaws.model;

import java.util.ArrayList;
import java.util.List;

public class ImagemDAO {

	Imagem imagem1 = new Imagem();
	Imagem imagem2 = new Imagem();
	Imagem imagem3 = new Imagem();
	Imagem imagem4 = new Imagem();

	public ImagemDAO() {
	}

	public void crearInstancia() throws Exception {

	}

	public List<Imagem> getInstancia() {
		ArrayList<Imagem> listaImagem = new ArrayList<Imagem>();
		imagem1.setId("ami-4836a428");
		imagem1.setDescricao("Amazon Linux AMI 2017.03.0 (HVM), SSD Volume Type");
		imagem1.setArquitetura("64 bit");
		imagem1.setState("available");

		imagem2.setId("ami-6f68cf0f");
		imagem2.setDescricao("Red Hat Enterprise Linux 7.3 (HVM), SSD Volume Type");
		imagem2.setArquitetura("64 bit");
		imagem2.setState("available");

		imagem3.setId("ami-e4a30084");
		imagem3.setDescricao("SUSE Linux Enterprise Server 12 SP2 (HVM), SSD Volume Type");
		imagem3.setArquitetura("64 bit");
		imagem3.setState("available");

		imagem4.setId("ami-efd0428f");
		imagem4.setDescricao("Ubuntu Server 16.04 LTS (HVM), SSD Volume Type ");
		imagem4.setArquitetura("64 bit");
		imagem4.setState("available");

		listaImagem.add(imagem1);
		listaImagem.add(imagem2);
		listaImagem.add(imagem3);
		listaImagem.add(imagem4);

		return listaImagem;
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
