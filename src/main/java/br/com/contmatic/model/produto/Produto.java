package br.com.contmatic.model.produto;

import java.math.BigDecimal;

public class Produto {

	private String nome;

	private String marca;

	private BigDecimal preco;

	private long codigo;

	public Produto(String nome, String marca, BigDecimal preco, long codigoProduto) {
		setNome(nome);
		setMarca(marca);
		setPreco(preco);
		setcodigo(codigoProduto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
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
		if (codigo != other.codigo)
			return false;
		return true;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;

	}

	public void setcodigo(long codigoProduto) {
		this.codigo = codigoProduto;
	}

	public void setMarca(String marca) {
		if (marca == null) {
			throw new IllegalArgumentException("Nome não deve ser nulo");
		}
		this.marca = marca;
	}

	public void setNome(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Nome não deve ser nulo");
		}
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public long getcodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Produto " + nome + ", marca: " + marca + ", preço: " + preco + ", codigoProduto de produto: " + codigo;
	}

}
