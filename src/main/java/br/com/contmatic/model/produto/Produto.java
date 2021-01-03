package br.com.contmatic.model.produto;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;

import java.math.BigDecimal;

import br.com.contmatic.model.auditoria.Auditoria;

public class Produto extends Auditoria {

	private static final String NOME_CLASSE = "Produto";
	
	private static final String NOME_MARCA = "Marca";
	
	private String nome;

	private String marca;

	private BigDecimal preco;

	private Long codigo;

	public Produto(String marca, Long codigo) {
		setMarca(marca);
		setCodigo(codigo);
	}

	public Produto(String nome, String marca, BigDecimal preco, Long codigo) {
		setNome(nome);
		setMarca(marca);
		setPreco(preco);
		setCodigo(codigo);
	}

	public void setPreco(BigDecimal preco) {
		validarCampoNulo(preco, "Preço", NOME_CLASSE);
		validarPrecoMinimoPermitido(preco);
		this.preco = preco;
	}

	public void setCodigo(Long codigo) {
		validarCampoNulo(codigo, "Codigo", NOME_CLASSE);
		this.codigo = codigo;
	}

	public void setMarca(String marca) {
		validarCampoNulo(marca, NOME_MARCA, NOME_CLASSE);
		validarCampoVazio(marca, NOME_MARCA, NOME_CLASSE);
		validarTamanho(1, 60, marca, NOME_MARCA, NOME_CLASSE);
		this.marca = marca;
	}

	public void setNome(String nome) {
		validarCampoNulo(nome, "Nome", NOME_CLASSE);
		validarCampoVazio(nome, "Nome", NOME_CLASSE);
		validarTamanho(1, 60, nome, "Nome", NOME_CLASSE);
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
