package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;
import static br.com.contmatic.model.validacao.ValidacaoCNPJ.validarCNPJ;

import java.util.List;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.produto.Produto;

public class Empresa extends Auditoria {

	private String nome;

	private String cnpj;

	private Endereco endereco;

	private List<Funcionario> funcionarios;

	private List<Produto> produtos;

	public Empresa(String nome, String cnpj) {
		this.setNome(nome);
		this.setCnpj(cnpj);
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

	public void setCnpj(String cnpj) {
		validarCampoNulo(cnpj, "CNPJ");
		validarCNPJ(cnpj);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setEndereco(Endereco endereco) {
		validarCampoNulo(endereco, "Endereço");
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		validarCampoNulo(funcionarios, "Funcionários");
		this.funcionarios = funcionarios;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		validarCampoNulo(produtos, "Produtos");
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cnpj == null) ? 0 : this.cnpj.hashCode());
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
		Empresa other = (Empresa) obj;
		if (this.cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!this.cnpj.equals(other.cnpj)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder empresaFields = new StringBuilder();
		empresaFields.append("Empresa [nome=").append(this.nome).append(", cnpj=").append(this.cnpj)
				.append(", endereco=").append(this.endereco).append(", funcionarios=").append(this.funcionarios)
				.append(", produtos=").append(this.produtos).append("]");
		return empresaFields.toString();
	}

}
