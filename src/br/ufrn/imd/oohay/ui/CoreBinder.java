package br.ufrn.imd.oohay.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.oohay.core.*;

/**
 * Classe de interfaceamento com o core do sistema.
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class CoreBinder implements FileObservable, SearchObservable {
	/**
	 * Instância do core do sistema
	 */
	private Oohay calcArvore;
	/**
	 * Lista de observers do tipo FileObserver
	 */
	private List<FileObserver> fileObservers;
	/**
	 * Lista de observers do tipo SearchObserver
	 */
	private List<SearchObserver> searchObservers;
	/**
	 * Armazenamento de resultados de buscas no sistema
	 */
	private ArrayList<Palavra> results;

	/**
	 * Modo "AND" de realização de busca
	 */
	public static final int AND_MODE = 1;
	/**
	 * Modo "OR" de realização de busca
	 */
	public static final int OR_MODE = 2;

	/**
	 * Construtor padrão que inicializa os valores iniciais dos atributos
	 */
	public CoreBinder() {
		this.calcArvore = new Oohay();
		this.fileObservers = new ArrayList<FileObserver>();
		this.searchObservers = new ArrayList<SearchObserver>();

		this.results = new ArrayList<Palavra>();
	}

	/**
	 * Adiciona observer na lista de FileObservers
	 */
	@Override
	public void subscribeFileObserver(FileObserver observer) {
		this.fileObservers.add(observer);
	}

	/**
	 * Notifica os observers do tipo FileObservers com lista de arquivos
	 */
	@Override
	public void notifyFileObservers() {
		for (FileObserver obs : fileObservers) {
			obs.update(calcArvore.getArquivos());
		}
	}

	/**
	 * Adiciona observar na lista de SearchObservers
	 */
	@Override
	public void subscribeSearchObserver(SearchObserver observer) {
		this.searchObservers.add(observer);
	}

	/**
	 * Notifica observers do tipo SearchObserver com valores armazenados em results
	 */
	@Override
	public void notifySearchObservers() {
		for (SearchObserver obs : searchObservers) {
			obs.update(this.results);
		}
	}

	/**
	 * Notifica observers do tipo SearchObserver com uma palavra sugerida para busca
	 */
	@Override
	public void notifySearchObserversWithSuggestion(Palavra word) {
		for (SearchObserver obs : searchObservers) {
			obs.suggest(word);
		}
	}

	/**
	 * Remove um arquivo a partir do índice na lista
	 * 
	 * @param index
	 *            indice para remoção
	 */
	public void removeFile(int index) {
		// pega o arquivo da classe principal
		Arquivo file = calcArvore.getArquivos().get(index);
		// remove o arquivo
		calcArvore.removerArquivo(file);
		this.notifyFileObservers();
	}

	/**
	 * Atualiza um arquivo já indexado, chamando o método de atualização da classe
	 * do core do sistema
	 * 
	 * @param index
	 *            índice do arquivo a ser atualizado
	 * @throws IOException
	 *             erro de arquivo
	 */
	public void refreshFile(int index) throws IOException {
		// pega o arquivo da classe principal
		Arquivo file = calcArvore.getArquivos().get(index);
		// atualiza o arquivo
		calcArvore.atualizarArquivo(file);
		this.notifyFileObservers();
	}

	/**
	 * Insere um novo arquivo no sistema
	 * 
	 * @param filePath
	 *            endereço do caminho para o arquivo a ser inserido
	 * @throws IOException
	 *             erro de arquivo
	 */
	public void insertFile(String filePath) throws IOException {
		calcArvore.inserirArquivo(new Arquivo(filePath));
		this.notifyFileObservers();
	}

	/**
	 * Busca palavras no sistema
	 * 
	 * @param term
	 *            termo a ser buscado
	 * @param mode
	 *            modo de busca "AND" ou "OR"
	 */
	public void searchWord(String term, int mode) {
		ArrayList<Palavra> result = new ArrayList<Palavra>();
		if (mode == AND_MODE) {
			result = calcArvore.buscarPalavra(term, "and");
		} else if (mode == OR_MODE) {
			result = calcArvore.buscarPalavra(term, "or");
		}

		this.results = result;

		if (!results.isEmpty()) {
			// A busca retornou resultados
			notifySearchObservers();
		} else {
			Suggestion sug = calcArvore.getSuggestionTo(term);
			if (sug.getCost() < 6) {
				// Notifica sugestão para os observers
				// A palavra da sugestão pode ser nula, no caso em que não exite nenhuma palavra
				// na árvore
				if (sug.getWord() != null) {
					notifySearchObserversWithSuggestion(sug.getWord());
					return;
				}
			}
			// Notifica os observers, mesmo com array de tamanho 0
			notifySearchObservers();
		}
	}

}
