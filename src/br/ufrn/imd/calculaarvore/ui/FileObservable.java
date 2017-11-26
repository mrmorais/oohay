package br.ufrn.imd.calculaarvore.ui;

public interface FileObservable {
	public void subscribeFileObserver(FileObserver observer);
	public void notifyFileObservers();
}
