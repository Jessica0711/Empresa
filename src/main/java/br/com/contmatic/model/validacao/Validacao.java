package br.com.contmatic.model.validacao;

import static java.lang.String.format;

public class Validacao {

	private Validacao() {
	}

	public static void validarCampoNulo(Object campo, String nomeCampo, String nomeClasse) {
		if (campo == null) {
			throw new IllegalArgumentException(format("O campo %s da classe %s não pode ser nulo", nomeCampo, nomeClasse));
		}
	}

	public static void validarCampoVazio(String campo, String nomeCampo, String nomeClasse) {
		if (campo.trim().isEmpty()) {
			throw new IllegalStateException(format("O campo %s da classe %s não pode ser vazio", nomeCampo, nomeClasse));
		}
	}

	public static void validarTamanho(int minimo, int maximo, String campo, String nomeCampo, String nomeClasse) {
		if (campo.length() < minimo || campo.length() > maximo) {
			throw new IllegalStateException(format("Tamanho inválido no campo %s, da classe %s", nomeCampo, nomeClasse));
		}
	}

}
