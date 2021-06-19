
package br.edu.gus.ifpe.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayList;

public class Addvenda {

	List<Item> itens = new ArrayList<>();

	
	public void adicionarItem(Item item) {
		if(!itens.contains(item))
		this.itens.add(item);
	}	
	public double calcularValorTotalVenda() {
		var total= 0.00;
		
		for (Item item : itens) {
			total = total + item.getProduto().getPreco() * item.getQuantidade();
	    }
		
		 return total;
	}
	
	public List<Item> getItens() {
	return Collections.unmodifiableList(this.itens);//Não quebra o encapslamento
}
	
	
}

