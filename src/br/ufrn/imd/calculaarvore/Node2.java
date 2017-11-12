package br.ufrn.imd.calculaarvore;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um nó na árvore digital
 * 
 * @author mrmorais
 * @version 1
 */
public class Node2 
{	
	private List<Node2> filhos; // Filhos do nó
	private Palavra palavra; // Palavra armazenada no nó
	
	public Node2() 
	{
		filhos = new ArrayList<Node2>();
		palavra = new Palavra("");
	}
	
	public Node2 buscaFilho(char proxLetra) {
		String nextStr = palavra.getValor() + proxLetra;
		for (Node2 filho : filhos) {
			if (filho.getPalavra().getValor().equals(nextStr)) return filho;
		}
		return null;
	}
	
	public Node2 criaFilho(char proxLetra) {
		String nextStr = palavra.getValor() + proxLetra;
		Node2 newFilho = new Node2();
		newFilho.getPalavra().setValor(nextStr);
		filhos.add(newFilho);
		return newFilho;
	}
	
	public Palavra getPalavra() {
		return palavra;
	}
}
