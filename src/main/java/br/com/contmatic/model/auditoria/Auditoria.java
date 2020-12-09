package br.com.contmatic.model.auditoria;

import org.joda.time.DateTime;

import br.com.contmatic.model.validacao.Validacao;

public class Auditoria {
	
	private static final String NOME_CLASSE = "Auditoria";

	private DateTime dataCadastro;

	private DateTime dataAlteracao;
	
	private String criadoPor;
	
	private String ultimaModificacao;
	
	private String ipCriadoPor;
	
	private String ipUltimaModificacao;

	public DateTime getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		Validacao.validarCampoNulo(dataCadastro, "Data de cadastro", NOME_CLASSE);
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataAlteracao() {
		return this.dataAlteracao;
	}
	
	public void setDataAlteracao(DateTime dataAlteracao) {
		Validacao.validarCampoNulo(dataAlteracao, "Data de alteração", NOME_CLASSE);
		this.dataAlteracao = dataAlteracao;
	}

	public String getCriadoPor() {
		return this.criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		Validacao.validarCampoNulo(criadoPor, "Criado por", NOME_CLASSE);
		Validacao.validarCampoVazio(criadoPor, "Criado por", NOME_CLASSE);
		this.criadoPor = criadoPor;
	}

	public String getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(String ultimaModificacao) {
		Validacao.validarCampoNulo(ultimaModificacao, "Ultima modificacao", NOME_CLASSE);
		Validacao.validarCampoVazio(ultimaModificacao, "Ultima modificacao", NOME_CLASSE);
		this.ultimaModificacao = ultimaModificacao;
	}

	public String getIpCriadoPor() {
		return this.ipCriadoPor;
	}

	public void setIpCriadoPor(String ipCriadoPor) {
		Validacao.validarCampoNulo(ipCriadoPor, "IP criado por", NOME_CLASSE);
		Validacao.validarCampoVazio(ipCriadoPor, "IP criado por", NOME_CLASSE);
		this.ipCriadoPor = ipCriadoPor;
	}

	public String getIpUltimaModificacao() {
		return this.ipUltimaModificacao;
	}

	public void setIpUltimaModificacao(String ipUltimaModificacao) {
		Validacao.validarCampoNulo(ipUltimaModificacao, "IP ultima modificacao", NOME_CLASSE);
		Validacao.validarCampoVazio(ipUltimaModificacao, "IP ultima modificacao", NOME_CLASSE);
		this.ipUltimaModificacao = ipUltimaModificacao;
	}

}
