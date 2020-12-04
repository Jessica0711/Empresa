package br.com.contmatic.model.produto;

import java.math.BigDecimal;

import br.com.contmatic.model.utils.Auditoria;

public class Produto extends Auditoria {

	private String nome;

	private String marca;

	private BigDecimal preco;

	private Long codigo;

	public Produto(String nome, String marca, BigDecimal preco, Long codigoProduto) {
		setNome(nome);
		setMarca(marca);
		setPreco(preco);
		setcodigo(codigoProduto);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (this.codigo ^ (this.codigo >>> 32));
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
		if (this.codigo != other.codigo)
			return false;
		return true;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;

	}

	public void setcodigo(Long codigoProduto) {
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
		return this.nome;
	}

	public String getMarca() {
		return this.marca;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	@Override
	public String toString() {
		return "Produto " + this.nome + ", marca: " + this.marca + ", preço: " + this.preco
				+ ", codigoProduto de produto: " + this.codigo;
	}

}
