package br.ufrn.imd.calculaarvore.ui.buscador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.ufrn.imd.calculaarvore.core.OcorrenciaArquivo;
import br.ufrn.imd.calculaarvore.core.Palavra;
import br.ufrn.imd.calculaarvore.ui.SearchObserver;

public class ResultsPane extends JPanel implements SearchObserver {
	private JTextArea resultArea;
	
	public ResultsPane(Color bgcolor) {
		super();
		setBackground(bgcolor);
		
		resultArea = new JTextArea(28, 42);
		resultArea.setEditable(false);
		resultArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(resultArea);
		add(scroll);
	}
	
	private void setResults(List<Palavra> words) {
		StringBuilder builder = new StringBuilder();
		for (Palavra w : words) {
			builder.append(strigifyWord(w));
		}
		
		resultArea.setText(builder.toString());
	}
	
	private String strigifyWord(Palavra word) {
		StringBuilder stringed = new StringBuilder();
		
		List<OcorrenciaArquivo> ocorrencias = word.getOcorrencias();
		for (OcorrenciaArquivo oa: ocorrencias) {
			stringed.append(oa.getArquivo().getNome());
			stringed.append(": ");
			stringed.append(oa.getnRepeticoes());
			stringed.append(" ocorrência da palavra '");
			stringed.append(word.getValor());
			stringed.append("' na linha ");
			stringed.append(oa.getLinha());
			stringed.append('\n');
		}
		return stringed.toString();
	}

	@Override
	public void update(List<Palavra> words) {
		setResults(words);
	}

}
