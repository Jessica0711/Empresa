package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;
import static br.com.contmatic.model.validacao.Validacao.validarTamanhoMinimoLista;
import static java.lang.String.format;

import java.util.List;

public class Estado {

	private static final String NOME_CLASSE = "Estado";

	private String nome;

	private List<Cidade> cidades;

	private Pais pais;

	public Estado(String nome, Pais pais) {
		setNome(nome);
		setPais(pais);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		validarCampoNulo(nome, "Nome", NOME_CLASSE);
		validarCampoVazio(nome, "Nome", NOME_CLASSE);
		validarTamanho(1, 80, nome, "Nome", NOME_CLASSE);
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		validarCampoNulo(cidades, "Cidades", NOME_CLASSE);
		validarTamanhoMinimoLista(1, cidades, "Cidades", NOME_CLASSE);
		validarCidadesPertencentesAoEstado(cidades);
		this.cidades = cidades;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		validarCampoNulo(pais, "País", NOME_CLASSE);
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		result = prime * result + ((this.pais == null) ? 0 : this.pais.hashCode());
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
		Estado other = (Estado) obj;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome)) {
			return false;
		}
		if (this.pais == null) {
			if (other.pais != null)
				return false;
		} else if (!this.pais.equals(other.pais)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder estadoFields = new StringBuilder();
		estadoFields.append("Estado [nome=").append(this.nome).append(", cidades=").append(this.cidades)
				.append(", pais=").append(this.pais).append("]");
		return estadoFields.toString();
	}

	private void validarCidadesPertencentesAoEstado(List<Cidade> cidades) {
		for (Cidade cidade : cidades) {
			if (!cidade.getEstado().equals(this)) {
				throw new IllegalStateException(
						format("A cidade %s não pertence ao estado %s", cidade.getNome(), this.nome));
			}
		}
	}

}
