package br.ufrn.imd.oohay.ui.indexador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ufrn.imd.oohay.ui.CoreBinder;

public class Indexador extends JPanel {
	public Indexador(CoreBinder binder) {
		super();
		setBackground(new Color(255, 255, 255));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new InsertFilePane(binder, getBackground()));
		
		FileListPane fileListPane = new FileListPane(binder, getBackground());
		binder.subscribeFileObserver(fileListPane);
		add(fileListPane);
	}
}
