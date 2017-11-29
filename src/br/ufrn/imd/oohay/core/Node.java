package br.ufrn.imd.oohay.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um nó na Árvore de Prefixos
 * 
 * @author mrmorais
 * @version 1
 */
public class Node implements Serializable {
	/**
	 * Lista de filhos do nó
	 */
	private List<Node> filhos;
	/**
	 * Palavra armazenada no nó
	 */
	private Palavra palavra;

	/**
	 * Construtor padrão que inicializa os atributos com valores iniciais
	 */
	public Node() {
		filhos = new ArrayList<Node>();
		palavra = new Palavra("");
	}

	/**
	 * Faz uma busca na lista de filhos pelo nó que possui o valor da palavra
	 * determinado por [valor da palavra do nó atual] + [proxLetra] em que a
	 * proxLetra é passada como parâmetro.
	 * 
	 * A complexidade deste método é da ordem de filhos.size()
	 * 
	 * @param proxLetra
	 *            letra que complementada à palavra do nó atual representa a palavra
	 *            do nó filho buscado
	 * @return Nó encontrado caso exista um, nulo caso não exista.
	 */
	public Node buscaFilho(char proxLetra) {
		String nextStr = palavra.getValor() + proxLetra;
		for (Node filho : filhos) {
			if (filho.getPalavra().getValor().equals(nextStr))
				return filho;
		}
		return null;
	}

	/**
	 * Cria um filho com a palavra de valor [valor da palavra do nó atual] +
	 * [proxLetra] em que a proxLetra é passada como parâmetro.
	 * 
	 * @param proxLetra
	 *            próxima letra que incrementará o valor da palavra atual na
	 *            instanciação de um novo nó filho
	 * @return Nó filho criado após instânciação
	 */
	public Node criaFilho(char proxLetra) {
		String nextStr = palavra.getValor() + proxLetra;
		Node newFilho = new Node();
		newFilho.getPalavra().setValor(nextStr);
		filhos.add(newFilho);
		return newFilho;
	}

	/**
	 * Altera palavra armazenada pelo nó
	 * 
	 * @param palavra
	 *            nova palavra
	 */
	public void setPalavra(Palavra palavra) {
		this.palavra = palavra;
	}

	/**
	 * Retorna a palavra armazenada pelo nó
	 * 
	 * @return palavra atualmenta armazenada no nó
	 */
	public Palavra getPalavra() {
		return palavra;
	}

	/**
	 * Retorna a lista de filhos do nó
	 * 
	 * @return lista de nós filhos
	 */
	public List<Node> getFilhos() {
		return filhos;
	}
}
