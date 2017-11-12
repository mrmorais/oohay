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
			princ.inserirArquivo("google.txt", "/home/mrmorais/calcula-arvore/data/lula.txt");
			Palavra tirei = princ.buscarPalavra("bilhões");
			System.out.println(tirei.getValor());
		} catch(Exception e) {
			fail();
		}
	}

}
