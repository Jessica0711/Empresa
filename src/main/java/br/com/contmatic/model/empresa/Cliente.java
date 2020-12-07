package br.com.contmatic.model.empresa;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.utils.Validacao;

public class Cliente extends Auditoria {

	private String nome;

	private String cpf;

	private Endereco endereco;

	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		Validacao.validarCampoNulo(nome, "Nome");
		Validacao.validarCampoVazio(nome, "Nome");
		Validacao.validarTamanho(1, 60, nome);
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		Validacao.validarCampoNulo(cpf, "CPF");
		Validacao.validarCPF(cpf);
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		Validacao.validarCampoNulo(endereco, "Endereço");
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (this.cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!this.cpf.equals(other.cpf)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente: " + this.nome + ", CPF: " + this.cpf + ", " + this.endereco;
	}

}