package br.ufrn.imd.calculaarvore;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um nó na árvore digital
 * 
 * @author mrmorais
 * @version 1
 */
public class Node 
{	
	private List<Node> filhos; // Filhos do nó
	private Palavra palavra; // Palavra armazenada no nó
	
	public Node() 
	{
		filhos = new ArrayList<Node>();
		palavra = new Palavra("");
	}
	
	public Node buscaFilho(char proxLetra) {
		String nextStr = palavra.getValor() + proxLetra;
		for (Node filho : filhos) {
			if (filho.getPalavra().getValor().equals(nextStr)) return filho;
		}
		return null;
	}
	
	public Node criaFilho(char proxLetra) {
		String nextStr = palavra.getValor() + proxLetra;
		Node newFilho = new Node();
		newFilho.getPalavra().setValor(nextStr);
		filhos.add(newFilho);
		return newFilho;
	}
	
	public Palavra getPalavra() {
		return palavra;
	}
}
