package br.com.contmatic.model.utils;

import java.util.InputMismatchException;

public class Validacao {

	private Validacao() {
	}

	public static void validarCampoNulo(Object campo, String nome) {
		if (campo == null) {
			throw new IllegalArgumentException(nome + " não pode ser nulo");
		}
	}

	public static void validarCampoVazio(String campo, String nome) {
		if (campo.trim().isEmpty()) {
			throw new IllegalStateException(nome + " não pode ser vazio");
		}
	}

	public static void validarTamanho(int minimo, int maximo, String campo) {
		if (campo.length() < minimo || campo.length() > maximo) {
			throw new IllegalStateException("Tamanho inválido");
		}
	}

	public static void validarCPF(String cpf) {
		if (!isCPF(cpf)) {
			throw new IllegalStateException("CPF inválido");
		}
	}

	public static void validarCNPJ(String cnpj) {
		if (!isCNPJ(cnpj)) {
			throw new IllegalStateException("CNPJ inválido");
		}
	}

	public static void validarCEP(String cep) {
		if (cep.equals("00000000") || cep.equals("11111111") || cep.equals("22222222") || cep.equals("33333333")
				|| cep.equals("44444444") || cep.equals("55555555") || cep.equals("66666666") || cep.equals("77777777")
				|| cep.equals("88888888") || cep.equals("99999999") || (cep.trim().length() != 8)) {
			throw new IllegalStateException("CEP inválido");
		}
	}

	private static boolean isCPF(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.trim().length() != 11)) {
			return (false);
		}

		char dig10;
		char dig11;
		int sm;
		int i;
		int r;
		int num;
		int peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				num = (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static boolean isCNPJ(String cnpj) {
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999") || (cnpj.trim().length() != 14)) {
			return (false);
		}

		char dig13;
		char dig14;
		int sm = 0;
		int i;
		int r;
		int num;
		int peso = 2;

		try {
			for (i = 11; i >= 0; i--) {
				num = (cnpj.charAt(i) - 48);
				sm += (num * peso);
				peso += 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			
			dig13 = calcularDigitoCnpj(r);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			dig14 = calcularDigitoCnpj(r);

			return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));

		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	private static char calcularDigitoCnpj(int r) {
		if ((r == 0) || (r == 1))
			return '0';
		else
			return (char) ((11 - r) + 48);
	}

}
