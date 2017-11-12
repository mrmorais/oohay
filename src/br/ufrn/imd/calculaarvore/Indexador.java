package br.ufrn.imd.calculaarvore;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Trabalha com leitura de arquivos, indexando palavras
 * @author mrmorais
 * @version 1
 */
public class Indexador {
	/**
	 * Ler todas as palavras de um arquivo indexando-as em uma lista do
	 * tipo Palavra.
	 * 
	 * A lista de palavras pode conter repetições de palavras, ou seja, elas não 
	 * são mescladas em um único objeto.
	 * 
	 * @param arquivo objeto da classe arquivo
	 * @return retorna uma lista de palavras indexadas
	 */
	public static List<Palavra> lerArquivo(Arquivo arquivo) throws FileNotFoundException, IOException {
		List<Palavra> words = new ArrayList<Palavra>(); // lista para resposta
		
		try
		{
			// cria um buffered reader para poder ler o arquivo por linha
			BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo.getFile()));
			
			String lineStr;
			int lineNum = 1;
			while ((lineStr = bufferedReader.readLine()) != null) {
				StringTokenizer stringTokenizer = new StringTokenizer(lineStr);
				
				// enquanto houver palavras na linha
				while(stringTokenizer.hasMoreTokens()) {
					String currentWord = stringTokenizer.nextToken().toLowerCase();
					String cleanCurrentWord = limpaPalavra(currentWord);
					if (cleanCurrentWord != null) {
						Palavra word = new Palavra(cleanCurrentWord);
						word.addOcorrencia(new OcorrenciaArquivo(arquivo, lineNum, 1));
						
						words.add(word);
					}
				}
				lineNum++; // incrementa o numero da linha
			}
			bufferedReader.close();
		}
		catch(Exception e)
		{
			System.out.println("Erro aqui");
		}
		return words;
	}
	
	private static String limpaPalavra(String palavra) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < palavra.length(); i++) {
			if (!isTrash(palavra.charAt(i))) {
				stringBuilder.append(palavra.charAt(i));
			}
		}
		String finalString = stringBuilder.toString();
		if (finalString.length() == 1 && finalString.charAt(0) == 8203) {
			finalString = "";
		}
		return finalString.length() == 0 ? null : stringBuilder.toString();
	}
	
	private static boolean isTrash(char character) {
		char [] trash = {' ',';', '.', ',', '!', '?', '(', ')', '[', ']', '{', '}', 
						 '"', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (char c : trash) {
			if (character == c) {
				return true;
			}
		}
		return false;
	}
	
}
