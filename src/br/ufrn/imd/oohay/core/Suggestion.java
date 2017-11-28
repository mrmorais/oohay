package br.ufrn.imd.oohay.core;

/**
 * Representa a sugestão de uma palavra retornada para o usuário
 * 
 * @author mrmorais
 * @version 1
 */
public class Suggestion {
	/**
	 * Palavra sugerida
	 */
	private Palavra word;
	/**
	 * Custo de construção da palavra com base na palavra geradora desta
	 */
	private int cost;

	/**
	 * Construtor padrão, inicializa os atributos com valores passados por parâmetro
	 * 
	 * @param word
	 *            palavra a ser sugerida
	 * @param cost
	 *            custo da sugestão
	 */
	public Suggestion(Palavra word, int cost) {
		this.word = word;
		this.cost = cost;
	}

	/**
	 * Retorna a palavra da sugestão
	 * 
	 * @return palavra a ser sugerida
	 */
	public Palavra getWord() {
		return word;
	}

	/**
	 * Altera a palavra da sugestão
	 * 
	 * @param word
	 *            nova palavra
	 */
	public void setWord(Palavra word) {
		this.word = word;
	}

	/**
	 * Retorna o valor inteiro que representa o custo da sugestão
	 * 
	 * @return valor do custo
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Altera o valor do custo da sugestão
	 * 
	 * @param cost
	 *            novo valor do custo
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

}
