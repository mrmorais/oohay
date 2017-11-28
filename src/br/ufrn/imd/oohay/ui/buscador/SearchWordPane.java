package br.ufrn.imd.oohay.ui.buscador;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufrn.imd.oohay.ui.CoreBinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel para realização de busca
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class SearchWordPane extends JPanel implements ActionListener {
	/**
	 * Instância do binder para executar solicitação de busca
	 */
	private CoreBinder binder;
	/**
	 * Campo de texto para inserção do termo buscado
	 */
	private JTextField word;
	/**
	 * Botão para efetuação da ação de busca
	 */
	private JButton searchBt;
	/**
	 * Dropdown para seleção do modo de busca
	 */
	private JComboBox<String> searchMode;

	/**
	 * Construtor padrão do painel
	 * 
	 * @param binder
	 *            core binder
	 * @param bgcolor
	 *            cor de plano de fundo do painel
	 */
	public SearchWordPane(CoreBinder binder, Color bgcolor) {
		super();
		this.binder = binder;
		setBackground(bgcolor);

		add(new JLabel("Termo para busca: "));
		this.word = new JTextField(15);
		add(word);

		this.searchBt = new JButton("Buscar");
		searchBt.setBackground(new Color(151, 236, 234));
		this.searchBt.addActionListener(this);
		add(searchBt);

		this.searchMode = new JComboBox<String>();
		this.searchMode.addItem("AND");
		this.searchMode.addItem("OR");
		add(searchMode);
	}

	/**
	 * Recebe ações do botão de busca e efetua a requisição de uma busca no core
	 * binder
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String currentWord = word.getText();
		String currentMode = (String) searchMode.getSelectedItem();

		if (currentWord.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira uma palavra para efetuar busca.", "Palavra vazia",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			if (currentMode == "AND") {
				binder.searchWord(currentWord, CoreBinder.AND_MODE);
			} else if (currentMode == "OR") {
				binder.searchWord(currentWord, CoreBinder.OR_MODE);
			}
		}
	}
}
