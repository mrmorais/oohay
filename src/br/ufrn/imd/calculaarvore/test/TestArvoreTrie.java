package br.ufrn.imd.calculaarvore.test;

import br.ufrn.imd.calculaarvore.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArvoreTrie {

	@Test
	public void testInserirPalavra() {
		ArvoreTrie arvoreTrie = new ArvoreTrie();
		
		try {
			arvoreTrie.insert(new Palavra("ola"));
			arvoreTrie.insert(new Palavra("olinda"));
			arvoreTrie.insert(new Palavra("amor"));
		} catch (Exception e) {
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
			
			Node busca = arvoreTrie.findWord("ola");
			if (busca == null) {
				fail();
			}
			System.out.println(busca.getPalavra().getValor());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
