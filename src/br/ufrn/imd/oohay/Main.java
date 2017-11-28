package br.ufrn.imd.oohay;

import br.ufrn.imd.oohay.ui.*;

/**
 * Classe principal que inicializa o sistema
 * 
 * @author mrmorais
 * @version 1
 *
 */
public class Main {
	/**
	 * Método estático main de execução Java
	 * 
	 * @param args
	 *            argumentos
	 */
	public static void main(String[] args) {
		CoreBinder coreBinder = new CoreBinder();
		MainFrame mFrame = new MainFrame(coreBinder);
	}
}
