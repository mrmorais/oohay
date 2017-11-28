package br.ufrn.imd.oohay.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.ufrn.imd.oohay.ui.buscador.Buscador;
import br.ufrn.imd.oohay.ui.indexador.Indexador;
import br.ufrn.imd.oohay.ui.sobre.Sobre;

/**
 * Janela principal da interface gráfica com usuário
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class MainFrame extends JFrame {
	/**
	 * Construtor padrão da classe. Recebe uma instância do tipo Binder que
	 * interliga a interface com o core do sistema.
	 * 
	 * @param binder
	 *            middleware que interfacea o GUI com o core do sistema
	 */
	public MainFrame(CoreBinder binder) {
		super("oohaY!");
		setLayout(new GridLayout(1, 1));

		JTabbedPane mainTabbedPanel = new JTabbedPane();

		mainTabbedPanel.addTab("Indexação", new Indexador(binder));

		mainTabbedPanel.addTab("Buscador", new Buscador(binder));

		mainTabbedPanel.addTab("Sobre", new Sobre());

		add(mainTabbedPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(478, 510);
		setLocation(100, 100);
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
	}
}
