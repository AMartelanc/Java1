package br.com.fiap.bean;

public class Upa {

	private int id;
	private String nome;
	private String endereco;
	private int cepUpa;
	private String cidade;
	private String uf;
	private int fone;
	
	
	public Upa() {}

	public Upa(int id, String nome, String endereco, int cepUpa, String cidade, String uf, int fone) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cepUpa = cepUpa;
		this.cidade = cidade;
		this.uf = uf;
		this.fone = fone;
	}
	
	public String mostrarAtributo() {
		return "Id: " + getId()+
				"\nNome: " + getNome()+
				"\nEndereco: " + getEndereco()+
				"\nCepUpa: " + getCepUpa()+
				"\nCidade: " + getCidade()+
				"\nUF: " + getUf()+
				"\nFone: " + getFone();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCepUpa() {
		return cepUpa;
	}

	public void setCepUpa(int cepUpa) {
		this.cepUpa = cepUpa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}
	
	
	
	
}
