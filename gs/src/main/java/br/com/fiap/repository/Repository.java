package br.com.fiap.repository;

import java.sql.Connection;

import br.com.fiap.dao.Conexao;

public abstract class Repository {
	protected static Connection connection;
	
	public Repository() {
		getConnection();
	}
	
	public static Connection getConnection() {
		try {
			connection = Conexao.getInstance().getConexao();
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void closeConnection() {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
