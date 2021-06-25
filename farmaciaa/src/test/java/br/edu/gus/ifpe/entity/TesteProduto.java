package br.edu.gus.ifpe.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TesteProduto {
	
	private Produto produto;
	private Categoria categoria;
	
	@Test
	public void CategoriaDoProduto() {
		produto = new  Produto("Dipirona", 100.00, new Categoria("Rem�dio"));
		assertNotNull(produto.getCategoria());
		assertEquals("Rem�dio", produto.getCategoria().getNome());
		
	}

}
//