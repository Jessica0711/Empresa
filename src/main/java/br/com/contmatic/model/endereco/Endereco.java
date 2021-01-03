package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.validacao.Validacao.validarCampoNulo;
import static br.com.contmatic.model.validacao.Validacao.validarCampoVazio;
import static br.com.contmatic.model.validacao.Validacao.validarTamanho;
import static br.com.contmatic.model.validacao.ValidacaoCEP.validarCEP;

import br.com.contmatic.model.auditoria.Auditoria;

public class Endereco extends Auditoria {

	private static final String NOME_CLASSE = "Endereco";
	private static final String CAMPO_BAIRRO = "Bairro";
	private static final String CAMPO_COMPLEMENTO = "Complemento";

	private String rua;

	private Integer numero;

	private String bairro;

	private String cep;

	private String complemento;

	private Cidade cidade;

	public Endereco(Integer numero, String cep) {
		setNumero(numero);
		setCep(cep);
	}

	public Endereco(String rua, Integer numero, String bairro, String cep, String complemento, Cidade cidade) {
		super();
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setCep(cep);
		setComplemento(complemento);
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		validarCampoNulo(rua, "Rua", NOME_CLASSE);
		validarCampoVazio(rua, "Rua", NOME_CLASSE);
		validarTamanho(1, 70, rua, "Rua", NOME_CLASSE);
		this.rua = rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		validarCampoNulo(numero, "Número", NOME_CLASSE);
		validarNumeroMinimoPermitido(numero);
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		validarCampoNulo(bairro, CAMPO_BAIRRO, NOME_CLASSE);
		validarCampoVazio(bairro, CAMPO_BAIRRO, NOME_CLASSE);
		validarTamanho(1, 60, bairro, CAMPO_BAIRRO, NOME_CLASSE);
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		validarCampoNulo(cep, "CEP", NOME_CLASSE);
		validarCEP(cep);
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		validarCampoNulo(complemento, CAMPO_COMPLEMENTO, NOME_CLASSE);
		validarCampoVazio(complemento, CAMPO_COMPLEMENTO, NOME_CLASSE);
		validarTamanho(0, 50, complemento, CAMPO_COMPLEMENTO, NOME_CLASSE);
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		validarCampoNulo(cidade, "cidade", NOME_CLASSE);
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep)) {
			return false;
		}
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder enderecoFields = new StringBuilder();
		enderecoFields.append("Endereco [rua=").append(rua).append(", numero=").append(numero).append(", bairro=")
				.append(bairro).append(", cep=").append(cep).append(", complemento=").append(complemento)
				.append(", cidade=").append(cidade).append("]");
		return enderecoFields.toString();
	}

	private void validarNumeroMinimoPermitido(Integer numero) {
		if (numero <= 0) {
			throw new IllegalStateException("Número deve ser maior que 0");
		}
	}

}
