package br.com.fiap.bean;

import jakarta.validation.constraints.NotNull;

public class Usuario {
	
	@NotNull
	private int cpf;
	@NotNull
	private int rg;
	@NotNull
	private int cep;
	private int fkUpa;
	
	public Usuario() {}

	public Usuario(@NotNull int cpf,@NotNull int rg,@NotNull int cep, int fkUpa) {
		this.cpf = cpf;
		this.rg = rg;
		this.cep = cep;
		this.fkUpa = fkUpa;
	}
	
	public String mostrarAtributo() {
		return "CPF: " + getCpf()+
				"\nRG: " + getRg()+
				"\nCEP: " + getCep()+
				"\nfkUpa: " + getFkUpa();
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
	public int getFkUpa() {
		return fkUpa;
	}

	public void setFkUpa(int fkUpa) {
		this.fkUpa = fkUpa;
	}
}
