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
		for (FileObserver obs: fileObservers) {
			System.out.println("notify obs --");
			obs.update(calcArvore.getArquivos());
		}
		
	}
	
	/**
	 * Insere um caminho de arquivo no core
	 * @param filePath
	 */
	public void insertFile(String filePath) {
		try {
			calcArvore.inserirArquivo(new Arquivo(filePath));
			this.notifyFileObservers();
			System.out.println(filePath);
		} catch(IOException exception) {
			// error while loading file
		}
	}
}
