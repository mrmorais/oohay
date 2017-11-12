package br.ufrn.imd.calculaarvore;

import java.util.ArrayList;
import java.util.List;

public class Palavra {

	protected String valor;
	protected List<OcorrenciaArquivo> ocorrencias;
	
	public Palavra(String valor) 
	{
		this.valor = valor;
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
	/*
	public void mesclarOcorrencias(Palavra origem) {
		for (OcorrenciaArquivo ocorrencia_origem : origem.getOcorrencias()) {
			boolean newOne = true;
			for (OcorrenciaArquivo ocorrencia_destino : ocorrencias) {
				if (ocorrencia_destino.getArquivo().getNome().equals(ocorrencia_origem.getArquivo().getNome())) {
					if (ocorrencia_destino.getLinha() == ocorrencia_origem.getLinha()) {
						ocorrencia_destino.setnRepeticoes(ocorrencia_destino.getnRepeticoes() + ocorrencia_origem.getnRepeticoes());
						newOne = false;
					}
				}
			}
			
			if (newOne) ocorrencias.add(ocorrencia_origem);
		}
	}
	*/
	public void mesclarOcorrencias(Palavra origem) 
	{	
		//Novas palavras inseridas sempre tem apenas 1 ocorrencia na sua lista de ocorrencia, 
		//devido ao indexador, que é o único que cria uma lista de palavras para serem inseridas, e elas sempre possuem apenas 1 ocorrencia.
		OcorrenciaArquivo novaOcorrencia = origem.getOcorrencias().get(0);
		
		for (OcorrenciaArquivo ocorrencia_destino : ocorrencias) 
		{
			if (ocorrencia_destino.getArquivo().getNome().equals(novaOcorrencia.getArquivo().getNome())) 
			{
				if (ocorrencia_destino.getLinha() == novaOcorrencia.getLinha()) 
				{
					ocorrencia_destino.setnRepeticoes(ocorrencia_destino.getnRepeticoes() + 1);
					return;
				}
			}
		}
		
		// Se a ocorrencia não veio do mesmo arquivo e mesma linha, será uma nova à lista daquela palavra
		ocorrencias.add(novaOcorrencia);
	}
	
	public List<OcorrenciaArquivo> getOcorrencias() {
		return this.ocorrencias;
	}
}
