package br.ufrn.imd.calculaarvore.test;

import br.ufrn.imd.calculaarvore.*;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.imd.calculaarvore.Principal;

public class TestPrincipal {

	@Test
	public void testInsercao() {
		Principal princ = new Principal();
		
		try {
			princ.inserirArquivo("lula.txt", "/home/mrmorais/calcula-arvore/data/lula.txt");
			Palavra tirei = princ.buscarPalavra("bilhões");
			System.out.println(tirei.getValor());
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testPalavrasRepetidas() {
		Principal princ = new Principal();
		
		try {
			princ.inserirArquivo("google.txt", "/home/mrmorais/calcula-arvore/data/google.txt");
			Palavra uma = princ.buscarPalavra("uma");
			System.out.println(uma.getOcorrencias().size());
			if (uma.getOcorrencias().size() < 2) {
				fail();
			}
		} catch(Exception e) {
			fail();
		}
	}

}
