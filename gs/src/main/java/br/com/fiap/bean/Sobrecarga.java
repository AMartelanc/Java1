package br.com.fiap.bean;

public class Sobrecarga {

	private int fkScUpa;
	private int fkScUser;
	private int notificacao;
	
	public Sobrecarga() {}

	public Sobrecarga(int fkScUpa, int fkScUser, int notificacao) {
		this.fkScUpa = fkScUpa;
		this.fkScUser = fkScUser;
		this.notificacao = notificacao;
	}

	public int getFkScUpa() {
		return fkScUpa;
	}

	public void setFkScUpa(int fkScUpa) {
		this.fkScUpa = fkScUpa;
	}

	public int getFkScUser() {
		return fkScUser;
	}

	public void setFkScUser(int fkScUser) {
		this.fkScUser = fkScUser;
	}

	public int getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(int notificacao) {
		this.notificacao = notificacao;
	}
}
