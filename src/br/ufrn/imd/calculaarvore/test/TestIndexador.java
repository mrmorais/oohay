package br.ufrn.imd.calculaarvore.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import br.ufrn.imd.calculaarvore.*;

public class TestIndexador {

	@Test
	public void testIndexarArquivo() {
		Arquivo arquivo = new Arquivo("apple.txt", "/home/danielmarx/Documentos/TI/Pasta sem título/calcula-arvore/data/apple.txt");
		try {
			List<Palavra> palavras = Indexador.lerArquivo(arquivo);
			if (!palavras.get(0).getValor().equals("apple")) {
				fail();
			}
		} catch (Exception e) {
			fail();
		}
	}

}
