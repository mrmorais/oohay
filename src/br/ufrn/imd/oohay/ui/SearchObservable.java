package br.ufrn.imd.oohay.ui;

import br.ufrn.imd.oohay.core.Palavra;

public interface SearchObservable {
	public void subscribeSearchObserver(SearchObserver observer);
	public void notifySearchObservers();
	public void notifySearchObserversWithSuggestion(Palavra word);
}
