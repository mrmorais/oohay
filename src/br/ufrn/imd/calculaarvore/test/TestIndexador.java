package br.ufrn.imd.calculaarvore.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.Assert.*;

import br.ufrn.imd.calculaarvore.*;

public class TestIndexador {
	private final String path = "/home/mrmorais/eclipse-workspace/calcula-arvore";

	@Test
	public void testIndexarArquivo() {
		Arquivo arquivo = new Arquivo(path + "/data/apple.txt");
		try {
			List<Palavra> palavras = Indexador.lerArquivo(arquivo);
			
			assertEquals(palavras.get(0).getValor(), "apple");
		} catch (Exception e) {
			fail();
		}
	}

}
