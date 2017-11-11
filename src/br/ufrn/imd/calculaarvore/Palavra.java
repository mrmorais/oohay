package br.ufrn.imd.calculaarvore;

import java.util.ArrayList;

public class Palavra {

	protected String valor;
	protected ArrayList<OcorrenciaArquivo> ocorrencias;
	
	public Palavra( String v) 
	{
		this.valor = v;
		ocorrencias = new ArrayList<OcorrenciaArquivo>();
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * Adiciona uma ocorrencia à palavra
	 * @param ocorrencia
	 */
	public void addOcorrencia(OcorrenciaArquivo ocorrencia)
	{
		ocorrencias.add(ocorrencia);
	}
}
