package br.com.contmatic.model.auditoria;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;

import org.joda.time.DateTime;

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
		validarCampoNulo(dataCadastro, "Data de cadastro", NOME_CLASSE);
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(DateTime dataAlteracao) {
		validarCampoNulo(dataAlteracao, "Data de alteração", NOME_CLASSE);
		this.dataAlteracao = dataAlteracao;
	}

	public String getCriadoPor() {
		return this.criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		validarCampoNulo(criadoPor, "Criado por", NOME_CLASSE);
		validarCampoVazio(criadoPor, "Criado por", NOME_CLASSE);
		this.criadoPor = criadoPor;
	}

	public String getUltimaModificacao() {
		return this.ultimaModificacao;
	}

	public void setUltimaModificacao(String ultimaModificacao) {
		validarCampoNulo(ultimaModificacao, "Ultima modificacao", NOME_CLASSE);
		validarCampoVazio(ultimaModificacao, "Ultima modificacao", NOME_CLASSE);
		this.ultimaModificacao = ultimaModificacao;
	}

	public String getIpCriadoPor() {
		return this.ipCriadoPor;
	}

	public void setIpCriadoPor(String ipCriadoPor) {
		validarCampoNulo(ipCriadoPor, "IP criado por", NOME_CLASSE);
		validarCampoVazio(ipCriadoPor, "IP criado por", NOME_CLASSE);
		this.ipCriadoPor = ipCriadoPor;
	}

	public String getIpUltimaModificacao() {
		return this.ipUltimaModificacao;
	}

	public void setIpUltimaModificacao(String ipUltimaModificacao) {
		validarCampoNulo(ipUltimaModificacao, "IP ultima modificacao", NOME_CLASSE);
		validarCampoVazio(ipUltimaModificacao, "IP ultima modificacao", NOME_CLASSE);
		this.ipUltimaModificacao = ipUltimaModificacao;
	}

	@Override
	public String toString() {
		StringBuilder auditoriaFields = new StringBuilder();
		auditoriaFields.append("Auditoria [dataCadastro=").append(dataCadastro).append(", dataAlteracao=")
				.append(dataAlteracao).append(", criadoPor=").append(criadoPor).append(", ultimaModificacao=")
				.append(ultimaModificacao).append(", ipCriadoPor=").append(ipCriadoPor).append(", ipUltimaModificacao=")
				.append(ipUltimaModificacao).append("]");
		return auditoriaFields.toString();
	}

}
