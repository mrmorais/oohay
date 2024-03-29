package br.ufrn.imd.oohay.ui.indexador;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;
import java.io.IOException;

import br.ufrn.imd.oohay.core.Arquivo;
import br.ufrn.imd.oohay.ui.CoreBinder;
import br.ufrn.imd.oohay.ui.FileObserver;

/**
 * Painel de listagem de arquivos
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class FileListPane extends JPanel implements FileObserver, ActionListener {
	/**
	 * Tabela de arquivos listados
	 */
	private JTable fileList;
	/**
	 * instância do binder com o core para executar ações de remoção e atualização
	 * de arquivos
	 */
	private CoreBinder binder;

	/**
	 * Construtor padrão do painel
	 * 
	 * @param binder
	 *            core binder
	 * @param bgColor
	 *            cor do plano de fundo
	 */
	public FileListPane(CoreBinder binder, Color bgColor) {
		setBackground(bgColor);
		this.binder = binder;

		// Criar pop up menu
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuFileRemove = new JMenuItem("Remover arquivo");
		menuFileRemove.addActionListener(this);
		menuFileRemove.setActionCommand("remove");

		JMenuItem menuFileRefresh = new JMenuItem("Atualizar arquivo");
		menuFileRefresh.addActionListener(this);
		menuFileRefresh.setActionCommand("refresh");

		// Adicionar items ao pop up menu
		popupMenu.add(menuFileRemove);
		popupMenu.add(menuFileRefresh);

		// Criar JTable
		fileList = new JTable();
		// Definir popupMenu para a tabela
		fileList.setComponentPopupMenu(popupMenu);
		// Setar os dados da tabela com uma lista vazia, apenas para preencher os
		// valores das colunas
		this.setTableData(new ArrayList<Arquivo>());

		// Determina o Mouse Listener para saber qual row foi selecionada para executar
		// a ação relacionada no popup menu
		fileList.addMouseListener(new TableMouseListener(fileList));

		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(fileList);

		add(scroll);
	}

	/**
	 * Altera os valores da tabela de arquivos com os arquivos passados por
	 * parâmetro
	 * 
	 * @param arquivos
	 *            arquivos que deverão compor a tabela
	 */
	public void setTableData(List<Arquivo> arquivos) {
		String columns[] = { "Nome do arquivo", "Quantidade de palavras" };
		String[][] data = new String[arquivos.size()][2];

		for (int i = 0; i < arquivos.size(); i++) {
			data[i][0] = arquivos.get(i).getNome();
			data[i][1] = String.valueOf(arquivos.get(i).getNumeroPalavras());
		}

		DefaultTableModel tabelModel = new DefaultTableModel(data, columns) {
			private static final long serialVersionUID = 2939668100969249259L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		fileList.setModel(tabelModel);
	}

	/**
	 * Recebe comando de atualização do FileObservable
	 */
	@Override
	public void update(List<Arquivo> files) {
		this.setTableData(files);
	}

	/**
	 * Recebe ação de atualização ou remoção e lança uma solicitação para o core
	 * binder
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = this.fileList.getSelectedRow();

		if (row >= 0) {
			if (e.getActionCommand() == "remove") {
				int confirmation = JOptionPane.showConfirmDialog(null,
						"Deseja realmente remover o arquivo da indexação? Ele não será excluído do "
								+ "seu computador.");
				if (confirmation == JOptionPane.YES_OPTION) {
					this.binder.removeFile(row);
				}
			} else if (e.getActionCommand() == "refresh") {
				try {
					this.binder.refreshFile(row);
				} catch (IOException exception) {
					exception.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo.", "IO Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um arquivo antes de executar uma ação.", "Ação inválida",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Classe especial para criação de eventos de clique na tabela
	 * 
	 * @author mrmorais
	 * @version 1
	 *
	 */
	private class TableMouseListener extends MouseAdapter {
		private JTable table;

		public TableMouseListener(JTable table) {
			this.table = table;
		}

		@Override
		public void mousePressed(MouseEvent event) {
			Point point = event.getPoint();
			int currentRow = table.rowAtPoint(point);
			table.setRowSelectionInterval(currentRow, currentRow);
		}
	}

}
