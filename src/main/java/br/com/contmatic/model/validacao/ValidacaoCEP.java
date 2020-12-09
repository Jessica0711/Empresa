package br.com.contmatic.model.validacao;

public class ValidacaoCEP {
	
	private ValidacaoCEP() {}
	
	public static void validarCEP(String cep) {
		if ( possuiSequenciaComMesmoNumero(cep) || (cep.trim().length() != 8)) {
			throw new IllegalStateException("CEP inválido");
		}
	}
	
	private static boolean possuiSequenciaComMesmoNumero(String cep) {
		return cep.equals("00000000") || cep.equals("11111111") || cep.equals("22222222") || cep.equals("33333333")
				|| cep.equals("44444444") || cep.equals("55555555") || cep.equals("66666666") || cep.equals("77777777")
				|| cep.equals("88888888") || cep.equals("99999999");
	}

}
