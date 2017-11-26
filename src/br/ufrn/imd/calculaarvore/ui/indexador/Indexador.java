package br.ufrn.imd.calculaarvore.ui.indexador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import br.ufrn.imd.calculaarvore.ui.CoreBinder;

public class Indexador extends JPanel {
	public Indexador(CoreBinder binder) {
		super();
		setBackground(new Color(255, 255, 255));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new InsertFilePane(binder, getBackground()));
		
		FileListPane fileListPane = new FileListPane(getBackground());
		binder.subscribeFileObserver(fileListPane);
		add(fileListPane);
		
		UpdateFilePane updateFilePane = new UpdateFilePane(getBackground());
		binder.subscribeFileObserver(updateFilePane);
		add(updateFilePane);
	}
}
