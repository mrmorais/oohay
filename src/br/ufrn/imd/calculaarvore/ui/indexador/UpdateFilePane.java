package br.ufrn.imd.calculaarvore.ui.indexador;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import br.ufrn.imd.calculaarvore.core.Arquivo;
import br.ufrn.imd.calculaarvore.ui.CoreBinder;
import br.ufrn.imd.calculaarvore.ui.FileObserver;

public class UpdateFilePane extends JPanel implements FileObserver {
	private List<Arquivo> arquivos;
	
	public UpdateFilePane(Color bgcolor) {
		super();
		setBackground(bgcolor);
	}

	@Override
	public void update(List<Arquivo> files) {
		this.arquivos = files;
	}
}
