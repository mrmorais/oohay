package br.ufrn.imd.calculaarvore.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.calculaarvore.core.*;

public class CoreBinder implements FileObservable {

	private CalculaArvore calcArvore;
	List<FileObserver> fileObservers;

	public CoreBinder() {
		this.calcArvore = new CalculaArvore();
		this.fileObservers = new ArrayList<FileObserver>();
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

}
