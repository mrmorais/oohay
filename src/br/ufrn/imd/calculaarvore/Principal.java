package br.ufrn.imd.calculaarvore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	private ArvoreTrie arvore;
	private ArrayList<Arquivo> arquivos;
	
	public Principal() 
	{
		arvore = new ArvoreTrie();
		arquivos = new ArrayList<Arquivo>();
	}
	
	/**
	 * Adiciona um novo arquivo à lista de arquivos passando um endereço.
	 * Todas as palavras do arquivo serão adicionadas à árvore trie.
	 * Inserir principal, faz interface com o usuário
	 * @param nome Nome do arquivo
	 * @param endNovoArq endereço do novo arquivo
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void inserirArquivo(String nome, String endNovoArq) throws FileNotFoundException, IOException
	{
		Arquivo novoArquivo = new Arquivo(nome, endNovoArq);
		inserirArquivo(novoArquivo);
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
			palavrasNoArquivo = Indexador.lerArquivo(arquivo);
			
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
		Palavra paraBusca = new Palavra(palavraBuscada);
		
		Node nodeAchado;
		
		nodeAchado = arvore.findWord(palavraBuscada);
		
		return nodeAchado.getPalavra();
	}
	
	/**
	 * Função auxiliar para inserir arquivos
	 * @param arquivo
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void inserirArquivo(Arquivo arquivo) throws FileNotFoundException, IOException
	{
		List<Palavra> palavrasNoArquivo;
		
		try 
		{
			palavrasNoArquivo = Indexador.lerArquivo(arquivo);
			arquivo.setNumeroPalavras(palavrasNoArquivo.size());
			
			for(Palavra p : palavrasNoArquivo)
			{
				arvore.insert(p);
			}
			
			arquivos.add(arquivo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + "Erro em inserirArquivo 02");
		}
		
	}
}
