package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;

public class Cidade {

	private static final String NOME_CLASSE = "Cidade";

	private String nome;

	private Estado estado;

	public Cidade(String nome, Estado estado) {
		setNome(nome);
		setEstado(estado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarCampoNulo(nome, "Nome", NOME_CLASSE);
		validarCampoVazio(nome, "Nome", NOME_CLASSE);
		validarTamanho(1, 80, nome, "Nome", NOME_CLASSE);
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validarCampoNulo(estado, "Estado", NOME_CLASSE);
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder cidadeFields = new StringBuilder();
		cidadeFields.append("Cidade [nome=").append(nome).append(", estado=").append(estado).append("]");
		return cidadeFields.toString();
	}

}
