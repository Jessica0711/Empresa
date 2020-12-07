package br.com.contmatic.model.empresa;

import java.math.BigDecimal;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.utils.Validacao;

public class Funcionario extends Auditoria {

	private String nome;

	private BigDecimal salario;

	private String cargo;

	private String cpf;

	public Funcionario(String nome, String cpf, BigDecimal salario, String cargo) {
		setNome(nome);
		setCPF(cpf);
		setSalario(salario);
		setCargo(cargo);
	}

	public void setNome(String nome) {
		Validacao.validarCampoNulo(nome, "Nome");
		Validacao.validarCampoVazio(nome, "Nome");
		Validacao.validarTamanho(1, 60, nome);
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setSalario(BigDecimal salario) {
		Validacao.validarCampoNulo(salario, "Salário");
		if (salario.doubleValue() <= 0) {
			throw new IllegalStateException("Sálario deve ser maior que 0");
		}
		this.salario = salario;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setCargo(String cargo) {
		Validacao.validarCampoNulo(cargo, "Cargo");
		Validacao.validarCampoVazio(cargo, "Cargo");
		Validacao.validarTamanho(1, 60, cargo);
		this.cargo = cargo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) {
		Validacao.validarCampoNulo(cpf, "CPF");
		Validacao.validarCPF(cpf);
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cpf == null) ? 0 : this.cpf.hashCode());
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
		Funcionario other = (Funcionario) obj;
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
		return "Funcionario(a) " + this.nome + ", CPF: " + this.cpf + ", salario: " + this.salario + ", this.cargo: "
				+ this.cargo;
	}
}
