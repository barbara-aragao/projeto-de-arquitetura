package br.edu.gus.ifpe.entity;

public class Produto {
 
	 private Categoria categoria;
	 private String nome;
	 private double preco;
	 private double descricao;


	public Produto(String nome, double preco, Categoria categoria) {
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}
	public void setCategoria(Categoria categoria) {
		 this.categoria = categoria;
	}
	public Categoria getCategoria(Categoria categoria) {
		return this.categoria = categoria;
	}
	
	
	public Categoria getCategoria() {
		return this.getCategoria();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getDescricao() {
		return descricao;
	}
	public void setDescricao(double descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		long temp;
		temp = Double.doubleToLongBits(descricao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (Double.doubleToLongBits(descricao) != Double.doubleToLongBits(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	
}
