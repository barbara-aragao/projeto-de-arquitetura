package br.edu.gus.ifpe.service;

import br.edu.gus.ifpe.entity.Desconto;
import br.edu.gus.ifpe.entity.Item;

public class DescontoService {
	
	private Desconto desconto;

	public DescontoService(Desconto desconto) {
		this.desconto = desconto;
		
	}
	
	public double calculaDescontoPorTresProdutosIguais() {
		var addvenda = desconto.getAddvenda();
		var total = addvenda.calcularValorTotalVenda();
 		for (Item item : addvenda.getItens()) {
       		if( item.getQuantidade() >= 3) {
		     	total -= ((item.getProduto().getPreco() * 3) * 0.1);
		}
}
		return total;
	}
	
}
