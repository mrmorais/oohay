package br.ufrn.imd.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert.*;

import br.ufrn.imd.oohay.core.*;

public class TestArvoreTrie {

	@Test
	public void testInserirPalavra() {
		ArvoreTrie arvoreTrie = new ArvoreTrie();
		
		try {
			arvoreTrie.insert(new Palavra("ola"));
			arvoreTrie.insert(new Palavra("olinda"));
			arvoreTrie.insert(new Palavra("amor"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testBuscaPalavra() {
		ArvoreTrie arvoreTrie = new ArvoreTrie();
		
		try {
			arvoreTrie.insert(new Palavra("ola"));
			arvoreTrie.insert(new Palavra("olinda"));
			arvoreTrie.insert(new Palavra("amor"));
			
			Node busca = arvoreTrie.findWord("olin");
			
			assertNotEquals(busca, null);
			
			System.out.println(busca.getPalavra().getValor());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
