package br.com.contmatic.model.auditoria;

import org.joda.time.DateTime;

import br.com.contmatic.model.validacao.Validacao;

public class Auditoria {

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
		Validacao.validarCampoNulo(dataCadastro, "Data de cadastro");
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataAlteracao() {
		return this.dataAlteracao;
	}
	
	public void setDataAlteracao(DateTime dataAlteracao) {
		Validacao.validarCampoNulo(dataAlteracao, "Data de alteração");
		this.dataAlteracao = dataAlteracao;
	}

	public String getCriadoPor() {
		return this.criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		Validacao.validarCampoNulo(criadoPor, "Criado por");
		Validacao.validarCampoVazio(criadoPor, "Criado por");
		this.criadoPor = criadoPor;
	}

	public String getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(String ultimaModificacao) {
		Validacao.validarCampoNulo(ultimaModificacao, "Ultima modificacao");
		Validacao.validarCampoVazio(ultimaModificacao, "Ultima modificacao");
		this.ultimaModificacao = ultimaModificacao;
	}

	public String getIpCriadoPor() {
		return this.ipCriadoPor;
	}

	public void setIpCriadoPor(String ipCriadoPor) {
		Validacao.validarCampoNulo(ipCriadoPor, "IP criado por");
		Validacao.validarCampoVazio(ipCriadoPor, "IP criado por");
		this.ipCriadoPor = ipCriadoPor;
	}

	public String getIpUltimaModificacao() {
		return this.ipUltimaModificacao;
	}

	public void setIpUltimaModificacao(String ipUltimaModificacao) {
		Validacao.validarCampoNulo(ipUltimaModificacao, "IP ultima modificacao");
		Validacao.validarCampoVazio(ipUltimaModificacao, "IP ultima modificacao");
		this.ipUltimaModificacao = ipUltimaModificacao;
	}

}
