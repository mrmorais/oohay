package br.ufrn.imd.oohay.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal que utiliza os componentes do sistema para interfacear com
 * outros módulos.
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class Oohay {
	/**
	 * Instância da árvore de prefixos para armazenamento das palavras
	 */
	private ArvoreTrie arvore;
	/**
	 * Arvore de palavras que representa uma lista de palavras não indexáveis
	 */
	private ArvoreTrie blackList;
	/**
	 * Lista de arquivos indexados no sistema
	 */
	private ArrayList<Arquivo> arquivos;

	private StoreContainer storeContainer;

	/**
	 * Construtor padrão que inicializa os atributos e gera a árvore que representa
	 * a lista negra de palavras
	 */
	public Oohay() {
		arvore = new ArvoreTrie();
		blackList = new ArvoreTrie();
		arquivos = new ArrayList<Arquivo>();
		storeContainer = new StoreContainer(arvore, arquivos);

		if (storeContainer.load("data/oohay.sav")) {
			arvore = storeContainer.getArvore();
			arquivos = storeContainer.getArquivos();
		}

		gerarBlackList("data/blackList.txt");
		this.store();
	}

	/**
	 * Adiciona um novo arquivo à lista de arquivos Todas as palavras do arquivo
	 * serão adicionadas à árvore trie. Inserir principal, faz interface com o
	 * usuário
	 * 
	 * @param arquivo
	 *            Objeto arquivo que será inserido
	 * @throws IOException
	 *             erro de acesso
	 * @throws FileNotFoundException
	 *             arquivo não encontrado
	 */
	public void inserirArquivo(Arquivo arquivo) throws FileNotFoundException, IOException {
		List<Palavra> palavrasNoArquivo;

		try {
			palavrasNoArquivo = Indexador.lerArquivo(arquivo, blackList);
			arquivo.setNumeroPalavras(palavrasNoArquivo.size());

			for (Palavra p : palavrasNoArquivo) {
				arvore.insert(p);
			}

			arquivos.add(arquivo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.store();
	}

	/**
	 * Remove o arquivo da lista de arquivos, bem como todas as suas palavras da
	 * árvore
	 * 
	 * @param arquivo
	 *            arquivo a ser excluído
	 */
	public void removerArquivo(Arquivo arquivo) {

		List<Palavra> palavrasNoArquivo;

		try {
			palavrasNoArquivo = Indexador.lerArquivo(arquivo, blackList);

			for (Palavra p : palavrasNoArquivo) {
				arvore.delete(p);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		arquivos.remove(arquivo);
		this.store();
	}

	/**
	 * Atualiza um arquivo já existente na árvore, não checa quais foram as
	 * mudanças.
	 * 
	 * @param arquivo
	 *            Arquivo a ser atualizado
	 * @throws FileNotFoundException
	 *             arquivo não encontrado
	 * @throws IOException
	 *             erro de acesso
	 */
	public void atualizarArquivo(Arquivo arquivo) throws FileNotFoundException, IOException {
		removerArquivo(arquivo);
		inserirArquivo(arquivo);
		this.store();
	}

	/**
	 * Encontrar uma palavra na árvore passando uma string.
	 * 
	 * @param palavraBuscada
	 *            String buscada
	 * @return um objeto Palavra
	 */
	public Palavra buscarPalavra(String palavraBuscada) {
		Node nodeAchado;

		nodeAchado = arvore.findWord(palavraBuscada.toLowerCase());
		if (nodeAchado != null)
			return nodeAchado.getPalavra();
		else
			return null;
	}

	/**
	 * Faz uma busca na árvore de prefixos por palavras que passem nos modos de
	 * busca "AND" ou "OR"
	 * 
	 * @param term
	 *            termo ou palavra pesquisada
	 * @param mode
	 *            modo de busca "and" ou "or"
	 * @return lista contendo palavras que combinam com a busca efetuada.
	 */
	public ArrayList<Palavra> buscarPalavra(String term, String mode) {
		String[] termsList = term.toLowerCase().split(" ");
		ArrayList<String> termsArr = new ArrayList<String>();
		for (int i = 0; i < termsList.length; i++) {
			termsArr.add(termsList[i]);
		}

		if (mode == "and") {
			return arvore.buscaAND(termsArr);
		} else if (mode == "or") {
			return arvore.buscaOR(termsArr);
		} else {
			return new ArrayList<Palavra>();
		}
	}

	/**
	 * Inicializa a árvore blackList indexando as palavra existentes no arquivo do
	 * caminho passado como parâmetro
	 * 
	 * @param enderecoArquivoBlackList
	 *            caminho no sistema de arquivos que aponta para o arquivo de
	 *            blacklist
	 */
	private void gerarBlackList(String enderecoArquivoBlackList) {

		List<Palavra> palavrasDaBlackList;
		Arquivo bListArquivo = new Arquivo(enderecoArquivoBlackList);

		try {
			palavrasDaBlackList = Indexador.lerArquivo(bListArquivo, null);
			bListArquivo.setNumeroPalavras(palavrasDaBlackList.size());

			for (Palavra p : palavrasDaBlackList) {
				blackList.insert(p);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Serializa a árvore e a lista de arquivos em um arquivo
	 */
	private void store() {
		storeContainer.store("data/oohay.sav");
	}

	/**
	 * Repassa um pedido de sugestão de palavras realizado pela árvore de palavras
	 * 
	 * @param word
	 *            palavra a ser combinada na sugestão
	 * @return sugestão contendo palavra e fator de proximidade entre a mesma e o
	 *         termo passado como parâmetro
	 */
	public Suggestion getSuggestionTo(String word) {
		return arvore.getSuggestionTo(word);
	}

	/**
	 * Retorna a lista de arquivos indexados no sistema
	 * 
	 * @return lista de arquivos
	 */
	public ArrayList<Arquivo> getArquivos() {
		return this.arquivos;
	}
}
