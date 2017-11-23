package br.ufrn.imd.calculaarvore.ui;

import java.awt.Color;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import br.ufrn.imd.calculaarvore.core.Arquivo;

public class FileListPane extends JPanel implements FileObserver {
	private JTable fileList;
	public FileListPane(Color bgColor) {
		setBackground(bgColor);
		
		fileList = new JTable();
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(fileList);
		
		add(scroll);
	}
	
	public void setTableData(List<Arquivo> arquivos) {
		String columns[] = {"Nome do arquivo", "Quantidade de palavras"};
		String[][] data = new String[arquivos.size()][2];
		
		for (int i = 0; i < arquivos.size(); i++) {
			data[i][0] = arquivos.get(i).getNome();
			data[i][1] = String.valueOf(arquivos.get(i).getNumeroPalavras());
		}
		
		DefaultTableModel tabelModel = new DefaultTableModel(data, columns);
		
		fileList.setModel(tabelModel);
	}

	@Override
	public void update(List<Arquivo> files) {
		this.setTableData(files);
	}
	
}
