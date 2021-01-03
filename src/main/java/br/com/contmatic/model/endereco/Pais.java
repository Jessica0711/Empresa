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
		return nome;
	}

	public void setNome(String nome) {
		validarCampoNulo(nome, "Nome", "País");
		validarCampoVazio(nome, "Nome", "País");
		validarTamanho(1, 80, nome, "Nome", "País");
		this.nome = nome;
	}

}
