package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;
import static br.com.contmatic.model.validacao.ValidacaoCPF.validarCPF;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;

public class Cliente extends Auditoria {
	
	private static final String NOME_CLASSE = "Cliente";

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
		validarCampoNulo(nome, "Nome", NOME_CLASSE);
		validarCampoVazio(nome, "Nome", NOME_CLASSE);
		validarTamanho(1, 60, nome, "Nome", NOME_CLASSE);
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		validarCampoNulo(cpf, "CPF", NOME_CLASSE);
		validarCPF(cpf);
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarCampoNulo(endereco, "Endereço", NOME_CLASSE);
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
		StringBuilder clienteFilds = new StringBuilder();
		clienteFilds.append("Cliente [nome=").append(this.nome).append(", cpf=").append(this.cpf).append(", endereco=")
				.append(this.endereco.toString()).append("]");
		return clienteFilds.toString();
	}

}