package br.com.contmatic.model.endereco;

public class Endereco {

	private String rua;

	private int numero;

	private String bairro;

	private String cep;

	private String complemento;

	public Endereco(String rua, int numero, String bairro, String cep) {
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setComplemento("Não possui");
	}

	public Endereco(String rua, int numero, String bairro, String cep, String complemento) {
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setComplemento(complemento);
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		if (rua == null || rua.trim().isEmpty()) {
			throw new IllegalArgumentException("Rua não pode estar em branco");
		}
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if (bairro == null || bairro.trim().isEmpty()) {
			throw new IllegalArgumentException("Bairro não pode estar em branco");
		}
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		if (complemento == null || complemento.trim().isEmpty()) {
			throw new IllegalArgumentException("Complemento não pode estar em branco");
		}
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + numero;
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
		} else if (!cep.equals(other.cep))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereço: " + rua + ", " + numero + ", " + bairro + ", CEP: " + cep + ", complemento: " + complemento;
	}

}
