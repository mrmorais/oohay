package br.ufrn.imd.calculaarvore.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InsertFilePane extends JPanel implements ActionListener {
	private CoreBinder binder;
	
	public InsertFilePane(CoreBinder binder, Color bgColor) {
		setBackground(bgColor);
		this.binder = binder;
		
		JButton loadFileBtn = new JButton("Carregar arquivo");
		loadFileBtn.addActionListener(this);
		loadFileBtn.setActionCommand("loadFile");
		loadFileBtn.setBackground(new Color(151, 236, 234));
		
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
					binder.insertFile(fileChooser.getSelectedFile().getAbsolutePath());
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}	
}
