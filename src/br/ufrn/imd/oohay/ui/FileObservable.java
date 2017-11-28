package br.ufrn.imd.oohay.ui;

/**
 * Interface que determina os métodos de um FileObservable; Classes deste tipo
 * são capazes de notificar FileObservers com lista de arquivos existentes no
 * sistema
 * 
 * @author mrmorais
 * @version 1
 *
 */
public interface FileObservable {
	public void subscribeFileObserver(FileObserver observer);

	public void notifyFileObservers();
}
