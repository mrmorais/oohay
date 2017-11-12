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
	
	public void mesclarOcorrencias(Palavra origem) {
		for (OcorrenciaArquivo ocorrencia_destino : ocorrencias) {
			for (OcorrenciaArquivo ocorrencia_origem : origem.getOcorrencias()) {
				if (ocorrencia_destino.getArquivo().getNome().equals(ocorrencia_origem.getArquivo().getNome())) {
					if (ocorrencia_destino.getLinha() == ocorrencia_origem.getLinha()) {
						// Match em mesmo arquivo e mesma linha
						ocorrencia_destino.setnRepeticoes(ocorrencia_destino.getnRepeticoes() + ocorrencia_origem.getnRepeticoes());
					}
				} else {
					// Sem match em mesmo arquivos
					ocorrencias.add(ocorrencia_origem);
				}
			}
		}
	}
	
	public List<OcorrenciaArquivo> getOcorrencias() {
		return this.ocorrencias;
	}
}
