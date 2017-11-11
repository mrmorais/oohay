package br.ufrn.imd.calculaarvore;

/**
 * Representa um arquivo do sistema de arquivos
 * 
 * @author mrmorais
 * @version 1
 */
public class Arquivo {
	private String nome;
	private String endereco;
	
	public Arquivo(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
