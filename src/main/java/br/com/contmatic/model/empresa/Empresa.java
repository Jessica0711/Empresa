package br.com.contmatic.model.empresa;

import java.util.List;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.produto.Produto;
import br.com.contmatic.model.utils.Auditoria;

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
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode estar vazio");
		}
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("Endereço não pode estar vazio");
		}
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
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
		return "Empresa: " + this.nome + ", cnpj: " + this.cnpj + ", endereco: " + this.endereco + ", funcionarios: "
				+ this.funcionarios + ", produtos: " + this.produtos;
	}

}
