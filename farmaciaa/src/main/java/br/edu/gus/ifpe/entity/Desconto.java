package br.edu.gus.ifpe.entity;

public class Desconto {
	
	private Addvenda addvenda;
 
	 public Desconto(Addvenda addvenda ) {
		 this.addvenda = addvenda;
	 }
	 
	 public Addvenda getAddvenda() {
		 return addvenda;
}
}
