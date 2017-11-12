package br.ufrn.imd.calculaarvore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreTrie2 {
	
	//Nó raiz da árvore, não contém palavra alguma
	private Node2 raiz;
	
	/**
	 * Construtor, inicializa raiz
	 */
	public ArvoreTrie2() 
	{
		raiz = new Node2();
	}
	
	/**
	 * Método público, irá inserir palavra desejada à árvore
	 * Método secundário, faz interface com o usuário
	 * @param newWord palavra a ser adicionada
	 */
	public void insert(Palavra newWord)
	{
		insert(raiz, newWord, 0);
	}
	
	/**
	 * Faz o trabalho de inserir uma dada palavra à árvore
	 * Método principal de inserção
	 * @param newNode Nó utilizado para percorrer a árvore. Caso seja passado como null, será criado no passo seguinte da recursão
	 * @param newWord Palavra a ser adicionada à árvore
	 * @param d auxilia na indentificação do nível ao qual a palavra será inserida
	 * @return novo nó inserido
	 */
	private Node2 insert(Node2 node, Palavra palavra, int level) {
		char currentChar = palavra.getValor().charAt(level);
		
		Node2 nodeFound = node.buscaFilho(currentChar);
		if (nodeFound == null) {
			Node2 newFilho = node.criaFilho(currentChar);
			if (palavra.getValor().length() - 1 == level) {
				newFilho.getPalavra().mesclarOcorrencias(palavra);
				return newFilho; // Palavra encontrada
			}
			return insert(newFilho, palavra, level+1);
		}
		return insert(nodeFound, palavra, level+1);
	}
	
	
	/**
	 * Busca uma dada palavra na árvore
	 * @param word
	 * @return nó em que se encontra a palavra
	 */
	public Node2 findWord(String palavra) 
	{
		return findWord(raiz, palavra, 0);
	}

	/**
	 * Método principal de busca
	 * @param node Nó por onde a busca irá iniciar
	 * @param word palavra buscada
	 * @param d auxilia para encontrar o nível em que se encontra a palavra buscada
	 * @return nó da palavra buscada
	 */
	private Node2 findWord(Node2 node, String palavra, int level) 
	{ 
		if (palavra.isEmpty()) return null;
		if (palavra.length() - 1 == level) return null;
		
		char currentChar = palavra.charAt(level);
		
		Node2 nodeFound = node.buscaFilho(currentChar);
		if (nodeFound == null) return null;
		return findWord(nodeFound, palavra, level + 1);
	}
	
	/**
	 * Deleta uma palavra passada, se ela existir na árvore
	 * @param k palavra a ser deletada
	 */
	public void delete(Palavra k) 
	{ 
		raiz = delete(raiz, k, 0); 
	}
	
	/**
	 * Método principal, faz a deleção da palavra em si.
	 * O método deleta o nó da palavra bem como seus parentes diretos que não possuírem nenhum filho com palavras 
	 * @param node Nó por onde se iniciará a busca da palavra a ser deletada
	 * @param k palavra a ser deletada
	 * @param d auxilia para encontrar o nível da palavra para deleção.
	 * @return nó parente do que foi deletado e que ainda possui filhos com alguma palavra. 
	 * Ou a própria raiz, caso a árvore fique vazia. 
	 */
	private Node delete(Node node, Palavra k, int d) {
	     if (node == null) 
	    	 return null;
	     
	     if (d == k.valor.length())
	         node.key = null;
	     else 
	     {
	        char c = k.valor.charAt(d);
	        node.next[c] = delete(node.next[c], k, d+1);
	     }
	     
	     if (node.key != null) 
	    	 return node;
	     
	     for (char c = 0; c < 26; c++)
	    	 if (node.next[c] != null) 
	    		 return node;
	     
	     return null;
	}	
	
	/**
	 * Localiza todas as palavras com dado prefíxo e as retorna uma lista.
	 * Faz uso do método auxiliar collect
	 * @param pre prefixo sendo buscado. Palavra com esse prefixo pode não estar na árvore
	 * @return Lista de palavras com prefixo procurado
	 */
	public ArrayList<Palavra> keysWithPrefix(Palavra pre) 
	{
	   ArrayList<Palavra> palavrasComOPrefixo = new ArrayList<Palavra>();
	   collect(findWord(raiz, pre, 0), pre, palavrasComOPrefixo);
	   return palavrasComOPrefixo;
	}
	
	/**
	 * Método auxiliar para achar as palavras com certo prefixo. 
	 * Preenche uma lista com as palavras encontradas na árvore que tiverem o prefixo buscado
	 * @param node nó por onde iniciará a busca por palavras
	 * @param pre palavra que pode vir a ser adicionada à lista de prefixos
	 * @param palavrasComOPrefixo lista de palavras
	 */
	private void collect(Node node, Palavra pre, ArrayList<Palavra> palavrasComOPrefixo) 
	{
	   if (node == null) 
		   return;
	   if (node.key.valor != null) 
		   palavrasComOPrefixo.add(pre);
		   
	   for (char c = 0; c < 26; c++)
	   {
	      collect(node.next[c], node.next[c].key, palavrasComOPrefixo);
	   }
	}
}