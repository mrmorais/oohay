package br.ufrn.imd.calculaarvore.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.calculaarvore.core.*;

public class CoreBinder implements FileObservable, SearchObservable {

	private CalculaArvore calcArvore;
	private List<FileObserver> fileObservers;
	private List<SearchObserver> searchObservers;
	private ArrayList<Palavra> results;
	
	
	public static final int AND_MODE = 1;
	public static final int OR_MODE = 2;
	

	public CoreBinder() {
		this.calcArvore = new CalculaArvore();
		this.fileObservers = new ArrayList<FileObserver>();
		this.searchObservers = new ArrayList<SearchObserver>();
		
		this.results = new ArrayList<Palavra>();
	}

	@Override
	public void subscribeFileObserver(FileObserver observer) {
		this.fileObservers.add(observer);
	}

	@Override
	public void notifyFileObservers() {
		for (FileObserver obs : fileObservers) {
			obs.update(calcArvore.getArquivos());
		}
	}
	
	@Override
	public void subscribeSearchObserver(SearchObserver observer) {
		this.searchObservers.add(observer);
	}

	@Override
	public void notifySearchObservers() {
		for (SearchObserver obs : searchObservers) {
			obs.update(this.results);
		}
	}
	
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

	public void refreshFile(int index) throws IOException {
		// pega o arquivo da classe principal
		Arquivo file = calcArvore.getArquivos().get(index);
		// atualiza o arquivo
		calcArvore.atualizarArquivo(file);
		this.notifyFileObservers();
	}

	/**
	 * Insere um caminho de arquivo no core
	 * 
	 * @param filePath
	 */
	public void insertFile(String filePath) throws IOException {
		calcArvore.inserirArquivo(new Arquivo(filePath));
		this.notifyFileObservers();		
	}
	
	public void searchWord(String term, int mode) {
		ArrayList<Palavra> result = new ArrayList<Palavra>();
		if (mode == AND_MODE) {
			result = calcArvore.buscarPalavra(term, "and");
		} else if (mode == OR_MODE) {
			result = calcArvore.buscarPalavra(term, "or");
		}
		
		this.results = result;
		if (results.size() > 0) {
			notifySearchObservers();
		} else {
			Suggestion sug = calcArvore.getSuggestionTo(term);
			if (sug.getCost() < 6) {
				// Notifica sugestão para os observers
				notifySearchObserversWithSuggestion(sug.getWord());
			} else {
				// Notifica os observers, mesmo com array de tamanho 0
				notifySearchObservers();
			}
		}
	}

}
