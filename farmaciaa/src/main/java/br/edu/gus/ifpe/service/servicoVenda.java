package br.edu.gus.ifpe.service;

import br.edu.gus.ifpe.entity.FormaPagamento;
import br.edu.gus.ifpe.entity.Addvenda;


public class servicoVenda { 
	
	 private Addvenda addvenda;
	 private FormaPagamento formaPagamento;
	 
	 public servicoVenda(Addvenda addvenda) {
		this.addvenda = addvenda;
		 
	 }
	
     public servicoVenda(Addvenda addvenda, FormaPagamento formaPagamento) {
	 this.addvenda = addvenda;
	 this.formaPagamento = formaPagamento;
	 
 }
     public double calculoDesconto() {
	    var total = addvenda.calcularValorTotalVenda();
		switch (formaPagamento) {
		case DEBITO:
			total -= addvenda.calcularValorTotalVenda() * 0.05;
			break;
		case BOLETO:
			total -= addvenda.calcularValorTotalVenda()* 0.1;
			default:
				break;
		}
		return total;
}
     public void setFormaPagamento(FormaPagamento formaPagamento) {
    	 this.formaPagamento = formaPagamento;
     }

 }
		