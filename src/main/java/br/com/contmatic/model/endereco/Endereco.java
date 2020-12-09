package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.Validacao.validarCEP;
import static br.com.contmatic.model.utils.Validacao.validarCampoNulo;
import static br.com.contmatic.model.utils.Validacao.validarCampoVazio;
import static br.com.contmatic.model.utils.Validacao.validarTamanho;

import br.com.contmatic.model.auditoria.Auditoria;

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
		validarCampoNulo(rua, "Rua");
		validarCampoVazio(rua, "Rua");
		validarTamanho(1, 70, rua);
		this.rua = rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		validarCampoNulo(numero, "Número");
		validarNumeroMinimoPermitido(numero);
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		validarCampoNulo(bairro, "Bairro");
		validarCampoVazio(bairro, "Bairro");
		validarTamanho(1, 60, bairro);
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		validarCampoNulo(cep, "CEP");
		validarCEP(cep);
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		validarCampoNulo(complemento, "Complemento");
		validarCampoVazio(complemento, "Complemento");
		validarTamanho(0, 50, complemento);
		this.complemento = complemento;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		validarCampoNulo(cidade, "Cidade");
		validarCampoVazio(cidade, "Cidade");
		validarTamanho(1, 60, cidade);
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		validarCampoNulo(estado, "Estado");
		validarCampoVazio(estado, "Estado");
		validarTamanho(2, 40, estado);
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
		StringBuilder enderecoFields = new StringBuilder();
		enderecoFields.append("Endereco [rua=").append(rua).append(", numero=").append(numero).append(", bairro=")
				.append(bairro).append(", cep=").append(cep).append(", complemento=").append(complemento)
				.append(", cidade=").append(cidade).append(", estado=").append(estado).append("]");
		return enderecoFields.toString();
	}

	private void validarNumeroMinimoPermitido(Integer numero) {
		if (numero <= 0) {
			throw new IllegalStateException("Número deve ser maior que 0");
		}
	}

}
