package br.ufrn.imd.oohay.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Faz a serialização da arvore e arquivos indexados em um arquivo de
 * armazenamento
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class StoreContainer implements Serializable {
	/**
	 * Identificação do serializável
	 */
	private static final long serialVersionUID = -1971395407654166009L;
	/**
	 * referencia para a arvore do sistema
	 */
	private ArvoreTrie arvore;
	/**
	 * referencia para a lista de arquivos
	 */
	private ArrayList<Arquivo> arquivos;

	/**
	 * Construtor que inicializa os objetos com referencias passadas por parametro
	 * 
	 * @param arvore
	 *            arvore de prefixos
	 * @param arquivos
	 *            lista de arquivos
	 */
	public StoreContainer(ArvoreTrie arvore, ArrayList<Arquivo> arquivos) {
		this.arvore = arvore;
		this.arquivos = arquivos;
	}

	/**
	 * Método que executa o armazenamento em um endereço especificado
	 * 
	 * @param datapath
	 *            endereço para armazenamento
	 * @return true caso o armazenamento ocorreu sem erros, false caso contrário
	 */
	public boolean store(String datapath) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(datapath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Realiza o carregamento de dados armazenados em uma arquivo especificado
	 * 
	 * @param datapath
	 *            endereço para carregamento
	 * @return true caso o carregamento ocorreu sem erros, false caso contrário
	 */
	public boolean load(String datapath) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(datapath);
			ois = new ObjectInputStream(fis);
			StoreContainer storedCont = (StoreContainer) ois.readObject();
			this.arvore = storedCont.arvore;
			this.arquivos = storedCont.arquivos;
			ois.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Retorna a árvore carregada por arquivo
	 * 
	 * @return arvore de prefixos
	 */
	public ArvoreTrie getArvore() {
		return this.arvore;
	}

	/**
	 * Retorna a lista de arquivos carregada por arquivo
	 * 
	 * @return lista de arquivos
	 */
	public ArrayList<Arquivo> getArquivos() {
		return this.arquivos;
	}
}
