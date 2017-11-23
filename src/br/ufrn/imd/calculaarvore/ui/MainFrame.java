package br.ufrn.imd.calculaarvore.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import javafx.scene.layout.Border;

public class MainFrame extends JFrame {
	public MainFrame(CoreBinder binder) {
		super("Calcula Árvore");
		setLayout(new GridLayout(1,1));
		
		JTabbedPane mainTabbedPanel = new JTabbedPane();
		
		mainTabbedPanel.addTab("Indexação", new Indexador(binder));
		
		mainTabbedPanel.addTab("Buscador", new Buscador());
		
		add(mainTabbedPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(478, 500);
		setLocation(100, 100);
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setVisible(true);
	}
}
