package br.ufrn.imd.calculaarvore.ui;

public interface SearchObservable {
	public void subscribeSearchObserver(SearchObserver observer);
	public void notifySearchObservers();
}
