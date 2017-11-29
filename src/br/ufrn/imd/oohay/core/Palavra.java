package br.ufrn.imd.oohay.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Uma palavra indexada no sistema
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class Palavra implements Serializable {
	/**
	 * Valor String da palavra
	 */
	protected String valor;
	/**
	 * Lista de ocorrências da palavra, cada elemento na lista representa uma
	 * aparição da palavra em algum arquivo, podendo existir mais de uma ocorrência
	 * para o mesmo arquivo.
	 */
	protected List<OcorrenciaArquivo> ocorrencias;

	public Palavra(String valor) {
		this.valor = valor;
		ocorrencias = new ArrayList<OcorrenciaArquivo>();
	}

	/**
	 * Retorna o valor da palavra
	 * 
	 * @return valor String da palavra armazenada
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Altera o valor da palavra
	 * 
	 * @param valor
	 *            valor para a palavra
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Adiciona uma ocorrencia à palavra
	 * 
	 * @param ocorrencia
	 *            ocorrência a ser adicionada
	 */
	public void addOcorrencia(OcorrenciaArquivo ocorrencia) {
		ocorrencias.add(ocorrencia);
	}

	/**
	 * Mescla ocorrências entre a palavra atual e uma palavra passada por
	 * parâmentro. Este método é fundamental para que novas inserções de palavras
	 * culminem na utilização de um mesmo nó na árvore de prefixos. De forma geral,
	 * o método insere na atual lista de ocorrências as ocorrências da palavra
	 * origem.
	 * 
	 * @param origem
	 *            palavra de origem a ser mesclada
	 */
	public void mesclarOcorrencias(Palavra origem) {
		// Novas palavras inseridas sempre tem apenas 1 ocorrencia na sua lista de
		// ocorrencia,
		// devido ao indexador, que é o único que cria uma lista de palavras para serem
		// inseridas, e elas sempre possuem apenas 1 ocorrencia.
		OcorrenciaArquivo novaOcorrencia = origem.getOcorrencias().get(0);

		for (OcorrenciaArquivo ocorrencia_destino : ocorrencias) {
			if (ocorrencia_destino.getArquivo().getNome().equals(novaOcorrencia.getArquivo().getNome())) {
				if (ocorrencia_destino.getLinha() == novaOcorrencia.getLinha()) {
					ocorrencia_destino.setnRepeticoes(ocorrencia_destino.getnRepeticoes() + 1);
					return;
				}
			}
		}

		// Se a ocorrencia não veio do mesmo arquivo e mesma linha, será uma nova à
		// lista daquela palavra
		ocorrencias.add(novaOcorrencia);
	}

	/**
	 * Exclui ocorrências baseado numa palavra de origem passada por parâmetro.
	 * Possui uma lógica de programação parecida com a função de mesclagem
	 * 
	 * @param origem
	 *            palavra de origem comparada
	 */
	public void excluirOcorrencia(Palavra origem) {
		OcorrenciaArquivo paraDelecao = origem.getOcorrencias().get(0);

		for (OcorrenciaArquivo ocorrencia_destino : ocorrencias) {
			if (ocorrencia_destino.getArquivo().getNome().equals(paraDelecao.getArquivo().getNome())) {
				if (ocorrencia_destino.getLinha() == paraDelecao.getLinha()) {
					if (ocorrencia_destino.getnRepeticoes() > 1)
						ocorrencia_destino.setnRepeticoes(ocorrencia_destino.getnRepeticoes() - 1);
					else
						ocorrencias.remove(ocorrencia_destino);
					return;
				}
			}
		}

	}

	/**
	 * Retorna a lista de ocorrencias da palavra
	 * 
	 * @return lista de ocorrencias
	 */
	public List<OcorrenciaArquivo> getOcorrencias() {
		return this.ocorrencias;
	}
}
