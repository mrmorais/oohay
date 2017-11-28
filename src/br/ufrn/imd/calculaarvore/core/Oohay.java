package br.ufrn.imd.calculaarvore.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Oohay {
	
	public static final String CAMINHO_BLACKLIST_DANIEL = "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore/data/blackList.txt";
	public static final String CAMINHO_BLACKLIST_MARADONA = "/home/mrmorais/calcula-arvore/data/blackList.txt";
	
	private ArvoreTrie arvore;
	private ArvoreTrie blackList;
	private ArrayList<Arquivo> arquivos;
	
	public Oohay() 
	{
		arvore = new ArvoreTrie();
		blackList = new ArvoreTrie();
		arquivos = new ArrayList<Arquivo>();
		gerarBlackList(CAMINHO_BLACKLIST_MARADONA);
	}
	
	/**
	 * Adiciona um novo arquivo à lista de arquivos
	 * Todas as palavras do arquivo serão adicionadas à árvore trie.
	 * Inserir principal, faz interface com o usuário
	 * @param arquivo Objeto arquivo que será inserido
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void inserirArquivo(Arquivo arquivo) throws FileNotFoundException, IOException
	{
		List<Palavra> palavrasNoArquivo;
		
		try 
		{
			palavrasNoArquivo = Indexador.lerArquivo(arquivo, blackList);
			arquivo.setNumeroPalavras(palavrasNoArquivo.size());
			
			for(Palavra p : palavrasNoArquivo)
			{
				arvore.insert(p);
			}
			
			arquivos.add(arquivo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Remove o arquivo da lista de arquivos, bem como todas as suas palavras da árvore
	 * @param arquivo arquivo a ser excluído
	 */
	public void removerArquivo(Arquivo arquivo)
	{
		
		List<Palavra> palavrasNoArquivo;
		
		try 
		{
			palavrasNoArquivo = Indexador.lerArquivo(arquivo, blackList);
			
			for(Palavra p : palavrasNoArquivo)
			{
				arvore.delete(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		arquivos.remove(arquivo);
	}
	
	/**
	 * Atualiza um arquivo já existente na árvore, não checa quais foram as mudanças.
	 * @param arquivo Arquivo a ser atualizado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void atualizarArquivo(Arquivo arquivo) throws FileNotFoundException, IOException
	{
		removerArquivo(arquivo);
		inserirArquivo(arquivo);
	}
	
	/**
	 * Encontrar uma palavra na árvore passando uma string.
	 * @param palavraBuscada String buscada
	 * @return um objeto Palavra
	 */
	public Palavra buscarPalavra(String palavraBuscada)
	{	
		Node nodeAchado;
		
		nodeAchado = arvore.findWord(palavraBuscada.toLowerCase());
		if(nodeAchado != null)
			return nodeAchado.getPalavra();
		else
			return null;
	}
	
	public ArrayList<Palavra> buscarPalavra(String term, String mode) {
		String[] termsList = term.toLowerCase().split(" ");
		ArrayList<String> termsArr = new ArrayList<String>();
		for (int i = 0; i < termsList.length; i++) {
			termsArr.add(termsList[i]);
		}
		
		if (mode == "and") {
			return arvore.buscaAND(termsArr);
		} else if (mode == "or") {
			return arvore.buscaOR(termsArr);
		} else {
			return new ArrayList<Palavra>();
		}
	}
	
	/**
	 * Retorna uma lista de palavras que contêm o prefixo passado
	 * @param prefixoBuscado prefixo que deve estar nas palavras da lista retornada
	 * @return Lista com palavras cujo valor contêm o prefixo especificado
	 */
	public ArrayList<Palavra> buscaPrefixo(String prefixoBuscado)
	{	
		return arvore.keysWithPrefix(prefixoBuscado);
	}
	
	private void gerarBlackList(String enderecoArquivoBlackList)
	{
		
		List<Palavra> palavrasDaBlackList;
		Arquivo bListArquivo = new Arquivo(enderecoArquivoBlackList);
		
		try 
		{
			palavrasDaBlackList = Indexador.lerArquivo(bListArquivo, null);
			bListArquivo.setNumeroPalavras(palavrasDaBlackList.size());
			
			for(Palavra p : palavrasDaBlackList)
			{	
				blackList.insert(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Arquivo> getArquivos() {
		return this.arquivos;
	}

	public Suggestion getSuggestionTo(String word) {
		return arvore.getSuggestionTo(word);
	}
	
}
