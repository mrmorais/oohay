package br.ufrn.imd.calculaarvore.test;

import br.ufrn.imd.calculaarvore.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArvoreTrie {

	@Test
	public void testInserirPalavra() {
		ArvoreTrie2 arvoreTrie = new ArvoreTrie2();
		
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
		ArvoreTrie2 arvoreTrie = new ArvoreTrie2();
		
		try {
			arvoreTrie.insert(new Palavra("ola"));
			arvoreTrie.insert(new Palavra("olinda"));
			arvoreTrie.insert(new Palavra("amor"));
			
			Node2 busca = arvoreTrie.findWord("ola");
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
