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
			Arquivo lula = new Arquivo("lula.txt", "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore/data/lula.txt");
			princ.inserirArquivo(lula);
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
			Arquivo google = new Arquivo("google.txt", "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore/data/google.txt");
			princ.inserirArquivo(google);
			Palavra uma = princ.buscarPalavra("inc");
			System.out.println(uma.getOcorrencias().size());
			System.out.println("Número de repetições em cada ocorrência: ");
			for (OcorrenciaArquivo a : uma.getOcorrencias() )
			{
				System.out.println(a.getnRepeticoes());
			}
			if (uma.getOcorrencias().size() < 1) {
				fail();
			}
			
		} catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testPalavrasRemoverPalavras() {
		Principal princ = new Principal();
		
		try {
			
			Arquivo google = new Arquivo("google.txt", "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore/data/google.txt");
			Arquivo apple = new Arquivo("apple.txt", "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore/data/apple.txt");
			
			princ.inserirArquivo(google);
			princ.inserirArquivo(apple);
			
			Palavra uma = princ.buscarPalavra("uma");
			System.out.println("Número de ocorrências sem deleção: " + uma.getOcorrencias().size());
			if (uma.getOcorrencias().size() < 2) {
				fail();
			}
			princ.removerArquivo(google);
			uma = princ.buscarPalavra("uma");
			System.out.println("Número de ocorrências após a : " + uma.getOcorrencias().size());
		} catch(Exception e) {
			fail();
		}
	}
	
}
