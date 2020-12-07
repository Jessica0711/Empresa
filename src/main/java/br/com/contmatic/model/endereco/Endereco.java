package br.com.contmatic.model.endereco;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.utils.Validacao;

public class Endereco extends Auditoria {

	private String rua;

	private Integer numero;

	private String bairro;

	private String cep;

	private String complemento;

	private String cidade;

	private String estado;

	public Endereco(String rua, Integer numero, String estado, String cep) {
		setRua(rua);
		setNumero(numero);
		setEstado(estado);
		setCep(cep);
	}

	public Endereco(String rua, Integer numero, String bairro, String cep, String complemento, String cidade,
			String estado) {
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setCep(cep);
		setComplemento(complemento);
		setEstado(estado);
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		Validacao.validarCampoNulo(rua, "Rua");
		Validacao.validarCampoVazio(rua, "Rua");
		Validacao.validarTamanho(1, 70, rua);
		this.rua = rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		Validacao.validarCampoNulo(numero, "Número");
		if (numero <= 0) {
			throw new IllegalStateException("Número deve ser maior que 0");
		}
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		Validacao.validarCampoNulo(bairro, "Bairro");
		Validacao.validarCampoVazio(bairro, "Bairro");
		Validacao.validarTamanho(1, 60, bairro);
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		Validacao.validarCampoNulo(cep, "CEP");
		Validacao.validarCEP(cep);
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		Validacao.validarCampoNulo(complemento, "Complemento");
		Validacao.validarCampoVazio(complemento, "Complemento");
		Validacao.validarTamanho(0, 50, complemento);
		this.complemento = complemento;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		Validacao.validarCampoNulo(cidade, "Cidade");
		Validacao.validarCampoVazio(cidade, "Cidade");
		Validacao.validarTamanho(1, 60, cidade);
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		Validacao.validarCampoNulo(estado, "Estado");
		Validacao.validarCampoVazio(estado, "Estado");
		Validacao.validarTamanho(2, 40, estado);
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado)) {
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
		return "Endereço: " + this.rua + ", " + this.numero + ", " + this.bairro + ", CEP: " + this.cep
				+ ", complemento: " + this.complemento;
	}

}
