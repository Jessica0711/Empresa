package br.com.contmatic.model.utils;

import org.joda.time.DateTime;

public class Auditoria {

	private DateTime dataCadastro;

	private DateTime dataAlteracao;

	public DateTime getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(DateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
}
