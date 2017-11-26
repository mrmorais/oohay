package br.ufrn.imd.calculaarvore.ui.buscador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import br.ufrn.imd.calculaarvore.ui.CoreBinder;
import javafx.scene.layout.Border;

public class Buscador extends JPanel {
	public Buscador(CoreBinder binder) {
		super();
		setBackground(new Color(255, 255, 255));
		
		add(new SearchWordPane(binder, getBackground()));
		
		ResultsPane resultsPane = new ResultsPane(getBackground());
		binder.subscribeSearchObserver(resultsPane);
		add(resultsPane);
		
	}
}
