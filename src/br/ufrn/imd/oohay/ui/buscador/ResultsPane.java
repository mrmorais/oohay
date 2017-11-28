package br.ufrn.imd.oohay.ui.buscador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.ufrn.imd.oohay.core.OcorrenciaArquivo;
import br.ufrn.imd.oohay.core.Palavra;
import br.ufrn.imd.oohay.ui.SearchObserver;

/**
 * Painel de resultados de pesquisa. Implementa SearchObserver para receber
 * notificações do binder com resultados de pesquisas
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class ResultsPane extends JPanel implements SearchObserver {
	/**
	 * Área de texto para escrita dos resultados da busca
	 */
	private JTextArea resultArea;

	/**
	 * Construtor padrão
	 * 
	 * @param bgcolor
	 *            cor do plano de fundo do painel
	 */
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

	/**
	 * Atualiza a área de texto com resultados de uma busca passados por parâmentro.
	 * Caso a lista de resultados seja vazia uma mensagem adequada é retornada
	 * 
	 * @param words
	 *            palavras retornadas por uma busca
	 */
	private void setResults(List<Palavra> words) {
		if (words.size() == 0) {
			resultArea.setText("A busca não retornou resultados.");
		} else {
			StringBuilder builder = new StringBuilder();
			for (Palavra w : words) {
				builder.append(strigifyWord(w));
			}
			resultArea.setText(builder.toString());
		}
	}

	/**
	 * Transforma as informações de ocorrências de uma palavra em uma String para
	 * escrita no painel de resultados
	 * 
	 * @param word
	 *            palavra a ser convertida para string
	 * @return texto que descreve a palavra passada
	 */
	private String strigifyWord(Palavra word) {
		StringBuilder stringed = new StringBuilder();

		List<OcorrenciaArquivo> ocorrencias = word.getOcorrencias();
		for (OcorrenciaArquivo oa : ocorrencias) {
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

	/**
	 * Recebe atualizações do SearchObservable contendo resultados de buscas
	 */
	@Override
	public void update(List<Palavra> words) {
		setResults(words);
	}

	/**
	 * Recebe atualizações do SearchObservable contendo uma palavra a ser sugerida
	 */
	@Override
	public void suggest(Palavra word) {
		resultArea.setText("A busca não retornou resultados. Mas você quis dizer '" + word.getValor() + "'?");
	}

}
