package br.ufrn.imd.oohay.ui;

public interface FileObservable {
	public void subscribeFileObserver(FileObserver observer);
	public void notifyFileObservers();
}
