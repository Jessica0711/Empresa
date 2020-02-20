package br.com.contmatic.model.empresa;

import java.math.BigDecimal;

public class Funcionario {

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
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode estar vazio");
		}
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setCargo(String cargo) {
		if (cargo == null || cargo.trim().isEmpty()) {
			throw new IllegalArgumentException("Cargo não pode estar vazio");
		}
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
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
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario(a) " + nome + ", CPF: " + cpf + ", salario: " + salario + ", cargo: " + cargo;
	}
}
