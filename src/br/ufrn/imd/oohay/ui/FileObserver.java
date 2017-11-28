package br.ufrn.imd.oohay.ui;

import java.util.List;

import br.ufrn.imd.oohay.core.*;

/**
 * Interface que permite a recepção de lista de arquivos às classes do tipo.
 * Observam os FileObservable
 * 
 * @author mrmorais
 * @version 1
 *
 */
public interface FileObserver {
	public void update(List<Arquivo> files);
}
