package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;

public class Pais {

	private String nome;

	public Pais(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		validarCampoNulo(nome, "Nome", "País");
		validarCampoVazio(nome, "Nome", "País");
		validarTamanho(1, 80, nome, "Nome", "País");
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
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
		Pais other = (Pais) obj;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder paisFields = new StringBuilder();
		paisFields.append("Pais [nome=").append(this.nome).append("]");
		return paisFields.toString();
	}

}
