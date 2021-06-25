package br.edu.gus.ifpe.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.edu.gus.ifpe.service.DescontoService;
import br.edu.gus.ifpe.service.servicoVenda;
public class TesteVendaRemedios {

	private Produto produto;
	private Produto produto3;
	private Addvenda addvenda;
	
	private Item item;
	private Item item2;
	
   @Before
    	public void iniciarCenario() {
		  //Produtos selecionados
		  addvenda = new Addvenda();
		  produto3 = new Produto("Doril", 20.00, new Categoria("remedios"));
		  produto = new Produto("Paracetemol", 100.00, new Categoria("remedios"));
		  item = new Item(produto3, 2);
	      item2 = new Item (produto, 3);
	}
	@Test
	  public void calcularValorTotalVenda() {
		
		  //Quando
		  addvenda.adicionarItem(item);
		  addvenda.adicionarItem(item2);
		  
		  //E quando
		  var total = addvenda.calcularValorTotalVenda();
		  
		  //Ent�o
		  assertEquals("340.00", total);
		  
	  }
	
	@Test
	  public void retornaListaDeItens() {
		  addvenda.adicionarItem(item);
		  assertTrue(1 <= addvenda.getItens().size());
		  
	  }
	  
	@Test
	public void naoDeveAdicionarItemUtilizandoMetodoListarItens() {
		 produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		 item=new Item(produto, 10);
		 assertThrows(UnsupportedOperationException.class,() -> addvenda.getItens().add(item));
	}
    @Test
    public void naoDeveAddItemDuplicado() {
    	 produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
    	 var produto2 = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		 item2=new Item(produto, 10);
		 item=new Item(produto2, 10);
		 addvenda.adicionarItem(item);
		 addvenda.adicionarItem(item2);
		 
		 //quando
		 var quantidadeTotalDeItens = addvenda.getItens().get(0).getQuantidade();
		 
		 //then
		 assertEquals(10, quantidadeTotalDeItens);
    }
    @Test
    public void verificaTotalpagamentoDebito() {
    	addvenda.adicionarItem(item);
    	addvenda.adicionarItem(item2);
    	//e
    	servicoVenda service = new servicoVenda(addvenda, FormaPagamento.DEBITO);
    	
    	//ent�o
    	assertEquals(308,00, service.calculoDesconto());
    }
    
    @Test
    public void verificaTotalPagmentoBoleto() {
    	addvenda.adicionarItem(item);
    	addvenda.adicionarItem(item2);
    	//e
    	servicoVenda service = new servicoVenda (addvenda, FormaPagamento.BOLETO);
    	
    	
    	//ent�o
    	assertEquals(276,00, service.calculoDesconto());
    }
    @Test
    public void descontoPorTresRemedios() {
    	//dado
    	  produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		  item = new Item(produto3, 2);
	      item2 = new Item (produto, 3);
	      
	   //   produto3 = new Produto("Doril", 20.00, new Categoria("Rem�dios"));
	   //   item = new Item (produto, 3);
	      
	      //quando
	      addvenda.adicionarItem(item2);
	   // addvenda.adicionarItem(item);
	      
	      //e
	      var total = addvenda.pegarValorTotal();
	      var desconto = new Desconto(addvenda);
	      var descontoService = new DescontoService(desconto);
	      
	      //entao
	      assertEquals(930.00, descontoService.calculaDescontoPorTresProdutosIguais());
    }

	

	//
	
}
/*package br.edu.gus.ifpe.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.junit.jupiter.api.Test;

import br.edu.gus.ifpe.service.DescontoService;
import br.edu.gus.ifpe.service.servicoVenda;
import br.edu.gus.ifpe.entity.Item;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteVendaRemedios {

	private Produto produto;
	private Produto produto3;
	private Addvenda addvenda;
	
	private Item item;
	private Item item2;
	
   @BeforeEach
    	public void iniciarCenario() {
		  //Produtos selecionados
		  addvenda = new Addvenda();
		  produto3 = new Produto("Doril", 20.00, new Categoria("Rem�dios"));
		  produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		  item = new Item(produto3, 2);
	      item2 = new Item (produto, 3);
	}
	@Test
	  public void calcularValorTotalVenda() {
		
		  //Quando
		  addvenda.adicionarItem(item);
		  addvenda.adicionarItem(item2);
		  
		  //E quando
		  var total = addvenda.calcularValorTotalVenda();
		  
		  //Ent�o
		  assertEquals(340.00, total);
	  }
	
	@Test
	  public void retornaListaDeItens() {
		  addvenda.adicionarItem(item);
		  assertTrue(1 <= addvenda.getItens().size());
		  
	  }
	  
	@Test
	public void naoDeveAdicionarItemUtilizandoMetodoListarItens() {
		 produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		 item=new Item(produto, 10);
		 assertThrows(UnsupportedOperationException.class,() -> addvenda.getItens().add(item));
	}
    @Test
    public void naoDeveAddItemDuplicado() {
    	 produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
    	 var produto2 = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		 item2=new Item(produto, 10);
		 item=new Item(produto2, 10);
		 addvenda.adicionarItem(item);
		 addvenda.adicionarItem(item2);
		 
		 //quando
		 var quantidadeTotalDeItens = addvenda.getItens().get(0).getQuantidade();
		 
		 //then
		 assertEquals(10, quantidadeTotalDeItens);
    }
    @Test
    public void verificaTotalpagamentoDebito() {
    	addvenda.adicionarItem(item);
    	addvenda.adicionarItem(item2);
    	//e
    	servicoVenda service = new servicoVenda(addvenda, FormaPagamento.DEBITO);
    	
    	//ent�o
    	assertEquals(308,00, service.calculoDesconto());
    }
    
    @Test
    public void verificaTotalPagmentoBoleto() {
    	addvenda.adicionarItem(item);
    	addvenda.adicionarItem(item2);
    	//e
    	servicoVenda service = new servicoVenda (addvenda, FormaPagamento.BOLETO);
    	
    	
    	//ent�o
    	assertEquals(276,00, service.calculoDesconto());
    }
    @Test
    public void descontoPorTresRemedios() {
    	//dado
    	  produto = new Produto("Paracetemol", 100.00, new Categoria("Rem�dios"));
		  item = new Item(produto3, 2);
	      item2 = new Item (produto, 3);
	      
	   //   produto3 = new Produto("Doril", 20.00, new Categoria("Rem�dios"));
	   //   item = new Item (produto, 3);
	      
	      //quando
	      addvenda.adicionarItem(item2);
	   // addvenda.adicionarItem(item);
	      
	      //e
	      var total = addvenda.pegarValorTotal();
	      var desconto = new Desconto(addvenda);
	      var descontoService = new DescontoService(desconto);
	      
	      //entao
	      assertEquals(930.00, descontoService.calculaDescontoPorTresProdutosIguais());
    }

	

	//
	
}
*/