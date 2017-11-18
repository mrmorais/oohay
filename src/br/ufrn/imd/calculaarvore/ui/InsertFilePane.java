package br.ufrn.imd.calculaarvore.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InsertFilePane extends JPanel implements ActionListener {
	public InsertFilePane() {
		JButton loadFileBtn = new JButton("Carregar arquivo");
		loadFileBtn.addActionListener(this);
		loadFileBtn.setActionCommand("loadFile");
		
		add(loadFileBtn);
	}

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
					// Implica que um arquivo foi selecionado
					// TODO: chama um callback, ou notificar observers
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
	
	
}
