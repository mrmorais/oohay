package br.ufrn.imd.oohay.core;

/**
 * Representa registro de ocorrências de aparecemento de uma palavra em um
 * Arquivo.
 * 
 * @author mrmorais
 * @version 1
 */
public class OcorrenciaArquivo {
	/**
	 * Arquivo em que o aparecimento é registrado
	 */
	protected Arquivo arquivo;
	/**
	 * Linha do arquivo em que a palavra aparece
	 */
	protected int linha;
	/**
	 * Número de repetições da palavra na linha em que aparece
	 */
	protected int nRepeticoes;

	/**
	 * Construtor padrão da classe, inicializa os atributos com os valores de
	 * parâmentro
	 * 
	 * @param arquivo
	 *            arquivo referenciado em que a ocorrência é registrada
	 * @param linha
	 *            linha do arquivo da aparição registrada
	 * @param numRepeticoes
	 *            quantidade de aparições na linha do arquivo
	 */
	public OcorrenciaArquivo(Arquivo arquivo, int linha, int numRepeticoes) {
		this.arquivo = arquivo;
		this.linha = linha;
		this.nRepeticoes = numRepeticoes;
	}

	/**
	 * Retorna o arquivo ao qual a ocorrência se refere
	 * 
	 * @return arquivo referenciado
	 */
	public Arquivo getArquivo() {
		return arquivo;
	}

	/**
	 * Altera o arquivo referenciado pela ocorrência
	 * 
	 * @param arquivo
	 *            novo arquivo
	 */
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * Retorna a linha em que a ocorrência foi registrada
	 * 
	 * @return linha
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * Altera a linha em que a ocorrência foi registrada
	 * 
	 * @param linha
	 *            nova linha de ocorrência
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	/**
	 * Retorna o número de repetições na linha de ocorrência
	 * 
	 * @return numero inteiro que representa a quantidade de repetições na linha
	 */
	public int getnRepeticoes() {
		return nRepeticoes;
	}

	/**
	 * Altera a quantidade de repetições de ocorrência na linha
	 * 
	 * @param nRepeticoes
	 *            novo número de repetições
	 */
	public void setnRepeticoes(int nRepeticoes) {
		this.nRepeticoes = nRepeticoes;
	}

}
