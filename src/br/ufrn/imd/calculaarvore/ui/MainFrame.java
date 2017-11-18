package br.ufrn.imd.calculaarvore.ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("Calcula Árvore");
		setLayout(new FlowLayout());
		
		InsertFilePane insFilePane = new InsertFilePane();
		add(insFilePane);
		
		FileListPane listFilesPane = new FileListPane();
		add(listFilesPane);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
