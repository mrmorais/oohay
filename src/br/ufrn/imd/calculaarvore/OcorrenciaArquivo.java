package br.ufrn.imd.calculaarvore;

public class OcorrenciaArquivo {
	
	protected Arquivo arquivo;
	protected int linha;
	protected int nRepeticoes;
	
	public OcorrenciaArquivo(Arquivo arquivo, int linha, int numRepeticoes) 
	{
		this.arquivo = arquivo;
		this.linha = linha;
		this.nRepeticoes = numRepeticoes;
		
	}

	/**
	 * @return the arquivo
	 */
	public Arquivo getArquivo() {
		return arquivo;
	}

	/**
	 * @param arquivo the arquivo to set
	 */
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	/**
	 * @return the nRepeticoes
	 */
	public int getnRepeticoes() {
		return nRepeticoes;
	}

	/**
	 * @param nRepeticoes the nRepeticoes to set
	 */
	public void setnRepeticoes(int nRepeticoes) {
		this.nRepeticoes = nRepeticoes;
	}

}
