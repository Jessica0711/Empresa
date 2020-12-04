package br.com.contmatic.model.endereco;

import br.com.contmatic.model.utils.Auditoria;

public class Endereco extends Auditoria {

	private String rua;

	private Integer numero;

	private String bairro;

	private String cep;

	private String complemento;

	private String cidade;

	private String estado;

	public Endereco(String rua, Integer numero, String cidade, String cep) {
		setRua(rua);
		setNumero(numero);
		setCidade(cidade);
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
		setCidade(cidade);
		setEstado(estado);
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		if (rua == null || rua.trim().isEmpty()) {
			throw new IllegalArgumentException("Rua não pode estar em branco");
		}
		this.rua = rua;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		if (bairro == null || bairro.trim().isEmpty()) {
			throw new IllegalArgumentException("Bairro não pode estar em branco");
		}
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		if (complemento == null || complemento.trim().isEmpty()) {
			throw new IllegalArgumentException("Complemento não pode estar em branco");
		}
		this.complemento = complemento;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.cep == null) ? 0 : this.cep.hashCode());
		result = prime * result + this.numero;
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
		if (this.cep == null) {
			if (other.cep != null)
				return false;
		} else if (!this.cep.equals(other.cep)) {
			return false;
		}
		if (this.numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereço: " + this.rua + ", " + this.numero + ", " + this.bairro + ", CEP: " + this.cep
				+ ", complemento: " + this.complemento;
	}

}
