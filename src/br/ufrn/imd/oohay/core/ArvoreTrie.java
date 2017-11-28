package br.ufrn.imd.oohay.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Árvore Trie do tipo "Árvore de Prefixos" utilizada para armazenar e buscar
 * palavras no sistema
 * 
 * @author danielmarx
 * @version 1
 */
public class ArvoreTrie {
	/**
	 * Nó raiz da árvore, não contém palavra alguma
	 */
	private Node raiz;

	/**
	 * Construtor, inicializa raiz
	 */
	public ArvoreTrie() {
		raiz = new Node();
	}

	/**
	 * Método público, irá inserir palavra desejada à árvore usando um método
	 * secundário, faz interface com a classe utilizadora
	 * 
	 * @param newWord
	 *            palavra a ser adicionada
	 */
	public void insert(Palavra newWord) {
		insert(raiz, newWord, 0);
	}

	/**
	 * Faz o trabalho de inserir uma dada palavra à árvore a partir de um nó
	 * especificado
	 * 
	 * @param node
	 *            Nó utilizado para percorrer a árvore. Caso seja passado como null,
	 *            será criado no passo seguinte da recursão
	 * @param palavra
	 *            Palavra a ser adicionada à árvore
	 * @param level
	 *            auxilia na indentificação do nível ao qual a palavra será inserida
	 * @return novo nó inserido
	 */
	private Node insert(Node node, Palavra palavra, int level) {
		char currentChar = palavra.getValor().charAt(level);

		Node nodeFound = node.buscaFilho(currentChar);
		if (nodeFound == null) {
			Node newFilho = node.criaFilho(currentChar);
			if (palavra.getValor().length() - 1 == level) {
				// Palavra do novo nó será a que queremos adicionar, com isso já teremos as
				// ocorrências O.k.
				newFilho.setPalavra(palavra);
				return newFilho; // Palavra encontrada
			}
			return insert(newFilho, palavra, level + 1);
		} else {
			if (palavra.getValor().length() - 1 == level) {
				nodeFound.getPalavra().mesclarOcorrencias(palavra);
				return nodeFound;
			}
		}
		return insert(nodeFound, palavra, level + 1);
	}

	/**
	 * Busca uma dada palavra na árvore
	 * 
	 * @param palavra
	 *            palavra buscada
	 * @return nó em que se encontra a palavra
	 */
	public Node findWord(String palavra) {
		return findWord(raiz, palavra, 0);
	}

	/**
	 * Método principal de busca
	 * 
	 * @param node
	 *            Nó por onde a busca irá iniciar
	 * @param palavra
	 *            palavra buscada
	 * @param level
	 *            auxilia para encontrar o nível em que se encontra a palavra
	 *            buscada
	 * @return nó da palavra buscada
	 */
	private Node findWord(Node node, String palavra, int level) {
		if (palavra.isEmpty())
			return null;
		if (palavra.length() == level) {
			if (node.getPalavra().getOcorrencias().size() > 0)
				return node;
			else
				return null;
		}
		char currentChar = palavra.charAt(level);

		Node nodeFound = node.buscaFilho(currentChar);
		if (nodeFound == null)
			return null;
		return findWord(nodeFound, palavra, level + 1);
	}

	/**
	 * Padrão de busca OR. Recebe uma lista de Strings e retorna uma lista de
	 * instâncias de Palavra se ao menos uma das Strings na lista tiver ocorrência
	 * nas palavras da árvore.
	 * 
	 * @param listaOr
	 *            lista contendo strings a serem buscadas na árvore
	 * @return lista de Palavras, se ao menos uma da busca tiver sido encontrada,
	 *         caso contrário retorna null.
	 */
	public ArrayList<Palavra> buscaOR(ArrayList<String> listaOr) {
		ArrayList<Palavra> listaRetorno = new ArrayList<Palavra>();

		for (String p : listaOr) {
			Node findNode = findWord(p);
			if (findNode != null) {
				if (findNode.getPalavra().getOcorrencias().size() != 0)
					listaRetorno.add(findNode.getPalavra());
			}
		}

		return listaRetorno;
	}

	/**
	 * Padrão de busca AND. Recebe uma lista de Strings e retorna uma lista de
	 * instâncias de Palabra se todas as Strings na lista tiverem ocorrência nas
	 * palavras da árvore.
	 * 
	 * @param listaAND
	 *            lista contendo Strings que se deseja encontrar a ocorrência
	 * @return lista de Palavras, se todas as Strings tiverem sido encontradas, caso
	 *         contrário retorna null.
	 */
	public ArrayList<Palavra> buscaAND(ArrayList<String> listaAND) {
		ArrayList<Palavra> listaRetorno = new ArrayList<Palavra>();

		for (String p : listaAND) {
			Node findNode = findWord(p);
			if (findNode != null) {
				listaRetorno.add(findNode.getPalavra());
			} else {
				return new ArrayList<Palavra>();
			}
		}
		return listaRetorno;
	}

	/**
	 * Deleta uma palavra passada, se ela existir na árvore
	 * 
	 * @param k
	 *            palavra a ser deletada
	 */
	public void delete(Palavra k) {
		raiz = delete(raiz, k, 0);
	}

	/**
	 * Método principal, faz a deleção da palavra em si. O método deleta o nó da
	 * palavra bem como seus parentes diretos que não possuírem nenhum filho com
	 * palavras
	 * 
	 * @param node
	 *            Nó por onde se iniciará a busca da palavra a ser deletada
	 * @param palavra
	 *            palavra a ser deletada
	 * @param level
	 *            auxilia para encontrar o nível da palavra para deleção.
	 * @return nó parente do que foi deletado e que ainda possui filhos com alguma
	 *         palavra. Ou a própria raiz, caso a árvore fique vazia.
	 */
	private Node delete(Node node, Palavra palavra, int level) {
		if (node == null) {
			return null;
		}

		if (level == palavra.getValor().length()) {
			node.getPalavra().excluirOcorrencia(palavra);
		} else {
			char currentChar = palavra.getValor().charAt(level);
			Node nodeFound = node.buscaFilho(currentChar);

			nodeFound = delete(nodeFound, palavra, level + 1);
		}

		if (!node.getFilhos().isEmpty())
			return node;

		return null;
	}

	/**
	 * Utilizando a distância de Levenshtein o método retorna a palavra mais próxima
	 * da palavra passada por parâmetro
	 * 
	 * @param word
	 *            palavra a ser comparada
	 * @return sugestão para palavra mais similar à palavra inserida
	 */
	public Suggestion getSuggestionTo(String word) {
		Palavra nearest = null;
		int minimumCost = 0;
		boolean first = true;

		ArrayList<Palavra> palavras = getAllWords();
		for (Palavra p : palavras) {
			int cost = Levenshtein.distance(word, p.getValor());
			if (first) {
				minimumCost = cost;
				nearest = p;
				first = false;
			} else {
				if (cost < minimumCost) {
					minimumCost = cost;
					nearest = p;
				}
			}
		}

		return new Suggestion(nearest, minimumCost);
	}

	/**
	 * Retorna uma lista de todas as palavras da árvore, fazendo um percorrimento
	 * por nível
	 * 
	 * @return lista de palavras
	 */
	public ArrayList<Palavra> getAllWords() {
		return getAllWords(raiz);
	}

	/**
	 * Método auxiliar para varrer todas as palavras da árvore
	 * 
	 * @param node
	 * @return lista de palavras
	 */
	private ArrayList<Palavra> getAllWords(Node node) {
		ArrayList<Palavra> words = new ArrayList<Palavra>();
		Queue<Node> queue = new LinkedList<Node>();

		if (node == null)
			return words; // é necessário?
		boolean first = true; // apenas uma flag para que o primeiro filho do primeiro nó

		while (!queue.isEmpty() || first) { // enquanto tiver nós na fila ou for a primeira vez
			first = false;
			if (!queue.isEmpty()) {
				// se a fila não está vazia, adiciono os filhos do nó cabeça na fila
				for (Node n : queue.peek().getFilhos()) {
					queue.add(n);
				}
				// por fim, consumo o nó cabeça na lista se ele possui uma palavra
				if (queue.peek().getPalavra().getOcorrencias().size() != 0) {
					// é uma palavra válida (contém ocorrências)
					words.add(queue.peek().getPalavra()); // consumo a palavra
				}
				queue.poll(); // removo da fila
			} else {
				// se a fila está vazia significa que é o primeiro passo. Adiciono os filhos
				// do nó
				if (!node.getFilhos().isEmpty()) {
					for (Node n : node.getFilhos()) {
						queue.add(n);
					}
				}
			}
		}

		return words;
	}

}