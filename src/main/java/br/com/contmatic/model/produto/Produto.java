package br.com.contmatic.model.produto;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;

import java.math.BigDecimal;

import br.com.contmatic.model.auditoria.Auditoria;

public class Produto extends Auditoria {

	private String nome;

	private String marca;

	private BigDecimal preco;

	private Long codigo;

	public Produto(String nome, String marca, BigDecimal preco, Long codigo) {
		setNome(nome);
		setMarca(marca);
		setPreco(preco);
		setCodigo(codigo);
	}

	public void setPreco(BigDecimal preco) {
		validarCampoNulo(preco, "Preço");
		validarPrecoMinimoPermitido(preco);
		this.preco = preco;
	}

	public void setCodigo(Long codigo) {
		validarCampoNulo(codigo, "Codigo");
		this.codigo = codigo;
	}

	public void setMarca(String marca) {
		validarCampoNulo(marca, "Marca");
		validarCampoVazio(marca, "Marca");
		validarTamanho(1, 60, marca);
		this.marca = marca;
	}

	public void setNome(String nome) {
		validarCampoNulo(nome, "Nome");
		validarCampoVazio(nome, "Nome");
		validarTamanho(1, 60, nome);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder produtoFields = new StringBuilder();
		produtoFields.append("Produto [nome=").append(nome).append(", marca=").append(marca).append(", preco=")
				.append(preco).append(", codigo=").append(codigo).append("]");
		return produtoFields.toString();
	}

	private void validarPrecoMinimoPermitido(BigDecimal preco) {
		if (preco.doubleValue() <= 0) {
			throw new IllegalStateException("Preço deve ser maior que 0");
		}
	}

}
