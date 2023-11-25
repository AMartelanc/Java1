package br.com.fiap.dao;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Conexao {
	
	private static Conexao instance;
	private Connection conexao;
	private String url;
	private String user;
	private String pass;
	private String driver;
	
	public Conexao(String url, String user, String pass, String driver) {
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.driver = driver;
	}
	
	public static Conexao getInstance() {
			Conexao result = instance;
			
			if (result != null) {
				return result;
			}
		
		Properties prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream("./src/main/resources/application.properties");
			prop.load(file);
			
			String url = prop.getProperty("datasource.url");
			String user = prop.getProperty("datasource.username");
			String pass = prop.getProperty("datasource.password");
			String driver = prop.getProperty("datasource.driver-class-name");
			file.close();
			
			if (instance == null) {
				instance = new Conexao(url, user, pass, driver);
			}
			return instance;
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} return null;
	}
	
	public Connection getConexao() {
		try {
			if (this.conexao != null && !this.conexao.isClosed()) {
				return this.conexao;
			}
			if (this.getDriver() == null || this.getDriver().equals("")) {
				System.out.println("Erro: nome da classe");
				throw new RuntimeException("Erro: nome da classe");
			}
			if (this.getUrl() == null || this.getUrl().equals("")) {
				System.out.println("Erro: Url de conexão");
				throw new RuntimeException("Erro: Url de conexão");
			}
			if (this.getUser() == null || this.getUser().equals("")) {
				System.out.println("Erro: Usuário incorreto");
				throw new RuntimeException("Erro: Usuário incorreto");
			}
			Class.forName(this.getDriver());
			this.conexao = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: nome da classe" + e.getMessage());
			System.exit(1);
		}	catch (SQLException e) {
			System.out.println("Erro de SQL" + e.getMessage());
			System.exit(1);
		}
		return conexao;
	}
	
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
	public String getDriver() {
		return driver;
	}
}

/**
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbx:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "rm550247";
			final String PASS = "210499";
			con = DriverManager.getConnection(url, USER, PASS);
			System.out.println("Conexao aberta.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexao fechada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}**/
