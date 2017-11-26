package br.ufrn.imd.calculaarvore.ui;

import java.util.List;

import br.ufrn.imd.calculaarvore.core.Palavra;

public interface SearchObserver {
	public void update(List<Palavra> words);
	public void suggest(Palavra word);
}
