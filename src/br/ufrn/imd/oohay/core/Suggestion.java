package br.ufrn.imd.oohay.core;

public class Suggestion {
	private Palavra word;
	private int cost;

	public Suggestion(Palavra word, int cost) {
		super();
		this.word = word;
		this.cost = cost;
	}

	public Palavra getWord() {
		return word;
	}

	public void setWord(Palavra word) {
		this.word = word;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
