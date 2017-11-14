package br.ufrn.imd.calculaarvore;

import java.io.File;

/**
 * Representa um arquivo do sistema de arquivos
 * 
 * @author mrmorais
 * @version 1
 */
public class Arquivo {
	private String nome; // 
	private File file;
	private int numeroPalavras;
	
	public Arquivo(String endereco) {
		super();
		this.file = new File(endereco);
		this.nome = file.getName();
		this.numeroPalavras = 0;
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
	
	public int getNumeroPalavras()
	{
		return numeroPalavras;
	}
	
	public void setNumeroPalavras(int numeroPalavras)
	{
		this.numeroPalavras = numeroPalavras;
	}
}
