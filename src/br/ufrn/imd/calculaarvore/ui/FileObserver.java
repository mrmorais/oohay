package br.ufrn.imd.calculaarvore.ui;
import java.util.List;

import br.ufrn.imd.calculaarvore.core.*;

public interface FileObserver {
	public void update(List<Arquivo> files);
}
