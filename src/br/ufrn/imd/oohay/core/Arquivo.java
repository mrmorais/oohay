package br.ufrn.imd.oohay.core;

import java.io.File;

/**
 * Representa um arquivo do sistema de arquivos, que foi (ou será) indexado para
 * a árvore de palavras
 * 
 * @author mrmorais
 * @version 1
 */
public class Arquivo {
	/**
	 * nome do aquivo tal como no sistema de arquivos do sistema operacional,
	 * inclusive com a extensão do mesmo.
	 */
	private String nome;
	/**
	 * objeto utilizado para acesso (leitura e escrita) no arquivo
	 */
	private File file;
	/**
	 * quantidade de palavras que o arquivo contém
	 */
	private int numeroPalavras;

	/**
	 * Construtor padrão da classe. Deve receber um endereço do sistema de arquivos
	 * para que seja localizado no SO.
	 * 
	 * @param endereco
	 *            endereço absoluto no sistema de arquivos
	 */
	public Arquivo(String endereco) {
		super();
		this.file = new File(endereco);
		this.nome = file.getName();
		this.numeroPalavras = 0;
	}

	/**
	 * Retorna o nome do arquivo com extensão
	 * 
	 * @return String contendo o nome do arquivo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o objeto de acesso ao arquivo no S.O.
	 * 
	 * @return File de acesso ao arquivo
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Altera o objeto de acesso ao arquivo no S.O.
	 * 
	 * @param file
	 *            Novo objeto de acesso ao arquivo
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Retorna o número de palavras encontradas no arquivo
	 * 
	 * @return inteiro que quantifica as palavras encontradas no arquivo
	 */
	public int getNumeroPalavras() {
		return numeroPalavras;
	}

	/**
	 * Altera o numero de palavras do arquivo
	 * 
	 * @param numeroPalavras
	 *            valor inteiro que determina o novo valor para quantidade de
	 *            palavras
	 */
	public void setNumeroPalavras(int numeroPalavras) {
		this.numeroPalavras = numeroPalavras;
	}
}
