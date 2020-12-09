package br.com.contmatic.model.validacao;

public class Validacao {

	private Validacao() {
	}

	public static void validarCampoNulo(Object campo, String nomeCampo) {
		if (campo == null) {
			throw new IllegalArgumentException(nomeCampo + " não pode ser nulo");
		}
	}

	public static void validarCampoVazio(String campo, String nomeCampo) {
		if (campo.trim().isEmpty()) {
			throw new IllegalStateException(nomeCampo + " não pode ser vazio");
		}
	}

	public static void validarTamanho(int minimo, int maximo, String campo) {
		if (campo.length() < minimo || campo.length() > maximo) {
			throw new IllegalStateException("Tamanho inválido");
		}
	}

}
