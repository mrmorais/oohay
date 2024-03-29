package br.ufrn.imd.oohay.ui.sobre;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Painel "Sobre" contendo informações do projeto
 * 
 * @author mrmorais
 * @version 1
 */
public class Sobre extends JPanel {
	/**
	 * Construtor padrão do painel
	 */
	public Sobre() {
		super();
		setBackground(new Color(255, 255, 255));

		add(new JLabel(new ImageIcon("res/img/oohay.png")), BorderLayout.CENTER);

		JTextArea jta = new JTextArea();
		jta.setEnabled(false);
		jta.setText("\n\n\nProjeto oohaY!\n\n" + "Desenvolvido por Maradona Morais e Daniel Marx como requisito \n"
				+ "para avaliação da 3º unidade das disciplinas Linguagem de \nProgramação "
				+ "II e Estruturas de Dados Básicas II.\n\n\n\n\n" + "IMD / UFRN. 2017");
		jta.setLineWrap(false);
		jta.setSize(400, 100);
		jta.setDisabledTextColor(new Color(0, 0, 0));

		add(jta);
	}
}
