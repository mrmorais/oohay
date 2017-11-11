package br.ufrn.imd.calculaarvore;

import java.io.File;

/**
 * Representa um arquivo do sistema de arquivos
 * 
 * @author mrmorais
 * @version 1
 */
public class Arquivo {
	private String nome;
	private File file;
	
	public Arquivo(String nome, String endereco) {
		super();
		this.nome = nome;
		this.file = new File(endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
