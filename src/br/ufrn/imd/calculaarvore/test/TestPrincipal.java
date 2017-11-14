package br.ufrn.imd.calculaarvore.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.swing.plaf.synth.SynthToggleButtonUI;

import org.junit.Test;

import br.ufrn.imd.calculaarvore.core.*;

public class TestPrincipal {
	private final String pathMaradona = "/home/mrmorais/eclipse-workspace/calcula-arvore";
	private final String pathDaniel = "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore";

	@Test
	public void testInsercao() {
		CalculaArvore princ = new CalculaArvore();
		
		try {
			Arquivo lula = new Arquivo(pathDaniel + "/data/lula.txt");
			princ.inserirArquivo(lula);
			Palavra bilhoes = princ.buscarPalavra("bilhões");
			
			assertEquals(bilhoes.getValor(), "bilhões");
		} catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testPalavrasRepetidas() {
		CalculaArvore princ = new CalculaArvore();
		
		try {
			Arquivo google = new Arquivo(pathDaniel + "/data/google.txt");
			princ.inserirArquivo(google);
			Palavra uma = princ.buscarPalavra("inc");
			System.out.println(uma.getOcorrencias().size());
			System.out.println("Número de repetições em cada ocorrência: ");
			for (OcorrenciaArquivo a : uma.getOcorrencias() )
			{
				System.out.println(a.getnRepeticoes());
			}
			assertTrue(uma.getOcorrencias().size() > 1);
			
		} catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testPalavrasRemoverPalavras() {
		CalculaArvore princ = new CalculaArvore();
		
		try {
			
			Arquivo google = new Arquivo(pathDaniel + "/data/google.txt");
			Arquivo apple = new Arquivo(pathDaniel + "/data/apple.txt");
			
			princ.inserirArquivo(google);
			princ.inserirArquivo(apple);
			
			Palavra uma = princ.buscarPalavra("uma");
			System.out.println("Número de ocorrências sem deleção: " + uma.getOcorrencias().size());
			
			assertTrue(uma.getOcorrencias().size() >= 2);
			
			princ.removerArquivo(google);
			uma = princ.buscarPalavra("uma");
			System.out.println("Número de ocorrências após a : " + uma.getOcorrencias().size());
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testBuscaPorPrefixo() {
		CalculaArvore princ = new CalculaArvore();
		
		try {
			
			String pre1 = "pro";
			String pre2 = "uni";
			
			Arquivo google = new Arquivo(pathDaniel + "/data/google.txt");
			
			princ.inserirArquivo(google);
			
			ArrayList<Palavra> prefixadas = princ.buscaPrefixo(pre1);
			ArrayList<Palavra> prefixadas2 = princ.buscaPrefixo(pre2);
			
			System.out.println("Prefixo: " + pre1 + "\n");
			for(Palavra p : prefixadas)
			{
				System.out.println(p.getValor());
			}
			
			System.out.println();
			System.out.println("Prefixo: " + pre2 + "\n");
			for(Palavra p : prefixadas2)
			{
				System.out.println(p.getValor());
			}
			
		} catch(Exception e) {
			fail();
		}
	}
	
}
