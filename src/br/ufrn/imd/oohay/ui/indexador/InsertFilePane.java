package br.ufrn.imd.oohay.ui.indexador;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.ufrn.imd.oohay.ui.CoreBinder;

/**
 * Painel para inserção de um novo arquivo
 * 
 * @author mrmorais
 *
 */
public class InsertFilePane extends JPanel implements ActionListener {
	/**
	 * Instância do core binder para execução de inserção de arquivos
	 */
	private CoreBinder binder;

	/**
	 * Construtor padrão do painel
	 * 
	 * @param binder
	 *            core binder
	 * @param bgColor
	 *            cor de plano de fundo do painel
	 */
	public InsertFilePane(CoreBinder binder, Color bgColor) {
		super();
		setBackground(bgColor);
		this.binder = binder;

		JButton loadFileBtn = new JButton("Carregar arquivo");
		loadFileBtn.addActionListener(this);
		loadFileBtn.setActionCommand("loadFile");
		loadFileBtn.setBackground(new Color(151, 236, 234));

		add(loadFileBtn);
	}

	/**
	 * Recebe ações lançadas pelo carregador de arquivos
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("loadFile")) {
			try {
				JFileChooser fileChooser = new JFileChooser();
				// Determina que o tipo do arquivo deve ser txt
				fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de texto", "txt"));
				// Abre a janela para escolha do arquivo
				int chooserPerform = fileChooser.showOpenDialog(null);
				if (chooserPerform == JFileChooser.APPROVE_OPTION) {
					binder.insertFile(fileChooser.getSelectedFile().getAbsolutePath());
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}
