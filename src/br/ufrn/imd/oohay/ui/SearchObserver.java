package br.ufrn.imd.oohay.ui;

import java.util.List;

import br.ufrn.imd.oohay.core.Palavra;

public interface SearchObserver {
	public void update(List<Palavra> words);
	public void suggest(Palavra word);
}
