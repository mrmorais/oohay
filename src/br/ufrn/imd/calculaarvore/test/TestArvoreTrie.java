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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
