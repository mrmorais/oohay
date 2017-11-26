package br.ufrn.imd.calculaarvore.ui;

import br.ufrn.imd.calculaarvore.core.Palavra;

public interface SearchObservable {
	public void subscribeSearchObserver(SearchObserver observer);
	public void notifySearchObservers();
	public void notifySearchObserversWithSuggestion(Palavra word);
}
