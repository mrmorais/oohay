package br.ufrn.imd.calculaarvore.ui;

import java.util.ArrayList;

import javax.swing.*;
import br.ufrn.imd.calculaarvore.core.Arquivo;

public class FileListPane extends JPanel {
	private JTable fileList;
	public FileListPane() {
		fileList = new JTable();
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(fileList);
		
		add(scroll);
	}
	
	public void setTableData(ArrayList<Arquivo> arquivos) {
		String columns[] = {"Nome do arquivo", "Endereço"};
		String[][] data = new String[arquivos.size()][2];
		
		for (int i = 0; i < arquivos.size(); i++) {
			data[i][0] = arquivos.get(i).getFile().getPath();
			data[i][1] = arquivos.get(i).getNome();
		}
		
		fileList = new JTable(data, columns);
	}
	
}
