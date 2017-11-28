package br.ufrn.imd.oohay.ui;

import br.ufrn.imd.oohay.core.Palavra;

/**
 * Interface que determina os métodos de um SearchObservable; Classes deste tipo
 * são capazes de notificar SearchObservers com lista de arquivos existentes no
 * sistema
 * 
 * @author mrmorais
 *
 */
public interface SearchObservable {
	public void subscribeSearchObserver(SearchObserver observer);

	public void notifySearchObservers();

	public void notifySearchObserversWithSuggestion(Palavra word);
}
