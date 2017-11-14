package br.ufrn.imd.calculaarvore.test;

import br.ufrn.imd.calculaarvore.*;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufrn.imd.calculaarvore.CalculaArvore;

public class TestPrincipal {
	private final String path = "/home/mrmorais/eclipse-workspace/calcula-arvore";
	
	@Test
	public void testInsercao() {
		CalculaArvore princ = new CalculaArvore();
		
		try {
			Arquivo lula = new Arquivo(path + "/data/lula.txt");
			princ.inserirArquivo(lula);
			Palavra tirei = princ.buscarPalavra("bilhões");
			System.out.println(tirei.getValor());
		} catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testPalavrasRepetidas() {
		CalculaArvore princ = new CalculaArvore();
		
		try {
			Arquivo google = new Arquivo(path + "/data/google.txt");
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
		CalculaArvore princ = new CalculaArvore();
		
		try {
			
			Arquivo google = new Arquivo(path + "/data/google.txt");
			Arquivo apple = new Arquivo(path + "/data/apple.txt");
			
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
