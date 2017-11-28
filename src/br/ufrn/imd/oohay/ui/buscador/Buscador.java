package br.ufrn.imd.oohay.ui.buscador;

import java.awt.Color;

import javax.swing.JPanel;

import br.ufrn.imd.oohay.ui.CoreBinder;

/**
 * Painel que contém os elementos de busca
 * 
 * @author mrmorais
 *
 */
public class Buscador extends JPanel {
	/**
	 * Construtor do painel, recebe o binder que é repassado para seus filhos
	 * 
	 * @param binder
	 */
	public Buscador(CoreBinder binder) {
		super();
		setBackground(new Color(255, 255, 255));

		add(new SearchWordPane(binder, getBackground()));

		ResultsPane resultsPane = new ResultsPane(getBackground());
		binder.subscribeSearchObserver(resultsPane);
		add(resultsPane);

	}
}
