package br.com.contmatic.model.validacao;

import java.util.InputMismatchException;

public final class ValidacaoCPF {

	private ValidacaoCPF() {
	}

	public static void validarCPF(String cpf) {
		if (!isCPF(cpf)) {
			throw new IllegalStateException("CPF inválido");
		}
	}

	private static boolean isCPF(String cpf) {
		verificarTamanhoCPF(cpf);
		possuiSequenciaComMesmoNumero(cpf);
		return verificarDigitosCpf(cpf);
	}

	private static boolean verificarDigitosCpf(String cpf) {
		try {
			char dig10 = calcularDigitoCPF(10, cpf, 9);
			char dig11 = calcularDigitoCPF(11, cpf, 10);
			return ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)));
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	private static void verificarTamanhoCPF(String cpf) {
		if (cpf.trim().length() != 11) {
			throw new IllegalStateException("Tamanho CPF inválido");
		}
	}

	private static void possuiSequenciaComMesmoNumero(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999")) {
			throw new IllegalStateException("CPF inválido");
		}
	}

	private static char calcularDigitoCPF(int peso, String cpf, int charPosition) {
		int r = 11 - (calcularSomaCPF(peso, cpf, charPosition) % 11);
		if ((r == 10) || (r == 11)) {
			return '0';
		} else {
			return (char) (r + 48);
		}
	}

	private static int calcularSomaCPF(int peso, String cpf, int charPosition) {
		int sm = 0;
		int num;
		for (int i = 0; i < charPosition; i++) {
			num = (cpf.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}
		return sm;
	}

}
