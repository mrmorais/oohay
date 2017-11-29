package br.ufrn.imd.oohay.ui.indexador;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import br.ufrn.imd.oohay.ui.CoreBinder;

/**
 * Painel que contém componentes para o processo de indexação de arquivos
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class Indexador extends JPanel {
	/**
	 * Construtor padrão do painel
	 * 
	 * @param binder
	 *            core binder
	 */
	public Indexador(CoreBinder binder) {
		super();
		setBackground(new Color(255, 255, 255));

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(new InsertFilePane(binder, getBackground()));

		FileListPane fileListPane = new FileListPane(binder, getBackground());
		binder.subscribeFileObserver(fileListPane);
		// Quando o sistema iniciar pode já conter arquivos carregados
		// por serialização. Então é importante notificar no início da
		// aplicação também
		binder.notifyFileObservers();
		add(fileListPane);
	}
}
