package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;
import static br.com.contmatic.model.validacao.ValidacaoCPF.validarCPF;

import java.math.BigDecimal;

import br.com.contmatic.model.auditoria.Auditoria;

public class Funcionario extends Auditoria {
	
	private static final String NOME_CLASSE = "Funcionario";
	private static final String CAMPO_CARGO = "Cargo";

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
		validarCampoNulo(nome, "Nome", NOME_CLASSE);
		validarCampoVazio(nome, "Nome", NOME_CLASSE);
		validarTamanho(1, 60, nome, "Nome", NOME_CLASSE);
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setSalario(BigDecimal salario) {
		validarCampoNulo(salario, "Salário", NOME_CLASSE);
		validarSalarioMinimoPermitido(salario);
		this.salario = salario;
	}

	public BigDecimal getSalario() {
		return this.salario;
	}

	public void setCargo(String cargo) {
		validarCampoNulo(cargo, CAMPO_CARGO, NOME_CLASSE);
		validarCampoVazio(cargo, CAMPO_CARGO, NOME_CLASSE);
		validarTamanho(1, 60, cargo, CAMPO_CARGO, NOME_CLASSE);
		this.cargo = cargo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) {
		validarCampoNulo(cpf, "CPF", NOME_CLASSE);
		validarCPF(cpf);
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
		StringBuilder funcionarioFields = new StringBuilder();
		funcionarioFields.append("Funcionario(a) ").append(this.nome).append(", CPF: ").append(this.cpf)
				.append(", salario: ").append(this.salario).append(", this.cargo: ").append(this.cargo);
		return funcionarioFields.toString();
	}

	private void validarSalarioMinimoPermitido(BigDecimal salario) {
		if (salario.doubleValue() <= 0) {
			throw new IllegalStateException("Sálario deve ser maior que 0");
		}
	}
}
