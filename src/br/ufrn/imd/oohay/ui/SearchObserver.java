package br.ufrn.imd.oohay.ui;

import java.util.List;

import br.ufrn.imd.oohay.core.Palavra;

/**
 * Interface que permite a recepção de lista de arquivos às classes do tipo.
 * Observam os SearchObservable
 * 
 * @author mrmorais
 * @version 1
 *
 */
public interface SearchObserver {
	public void update(List<Palavra> words);

	public void suggest(Palavra word);
}
