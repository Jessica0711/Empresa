package br.com.contmatic.model.validacao;

import java.util.InputMismatchException;

public class ValidacaoCNPJ {

	private ValidacaoCNPJ() {
	}

	public static void validarCNPJ(String cnpj) {
		if (!isCNPJ(cnpj)) {
			throw new IllegalStateException("CNPJ inválido");
		}
	}

	public static boolean isCNPJ(String cnpj) {
		verificarTamanhoCNPJ(cnpj);
		verificarContemSequenciaComMesmoNumero(cnpj);
		return verificarDigitosCnpj(cnpj);
	}

	private static boolean verificarDigitosCnpj(String cnpj) {
		try {
			char dig13 = calcularDigitoCnpj(cnpj, 11);
			char dig14 = calcularDigitoCnpj(cnpj, 12);
			return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	private static void verificarTamanhoCNPJ(String cnpj) {
		if (cnpj.trim().length() != 14) {
			throw new IllegalStateException("Tamanho CNPJ inválido");
		}
	}

	private static void verificarContemSequenciaComMesmoNumero(String cnpj) {
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999")) {
			throw new IllegalStateException("CNPJ inválido");
		}
	}

	private static char calcularDigitoCnpj(String cnpj, int posicaoCharFim) {
		int r = calcularSomaCNPJ(cnpj, posicaoCharFim) % 11;
		if ((r == 0) || (r == 1))
			return '0';
		else
			return (char) ((11 - r) + 48);
	}

	private static int calcularSomaCNPJ(String cnpj, int posicaoCharFim) {
		int sm = 0;
		int peso = 2;
		for (int i = posicaoCharFim; i >= 0; i--) {
			int num = (cnpj.charAt(i) - 48);
			sm += (num * peso);
			peso += 1;
			if (peso == 10)
				peso = 2;
		}
		return sm;
	}

}
