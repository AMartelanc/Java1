package br.com.fiap.dao;

import java.sql.*;
import java.util.*;

import br.com.fiap.bean.Usuario;
import br.com.fiap.repository.Repository;

public class UsuarioDAO extends Repository {
	private static Connection con;
	
	public UsuarioDAO(Connection con) {
		setCon(con);
	}
	
	public static Connection getCon() {
		return con;
	}
	
	public void setCon(Connection con) {
		UsuarioDAO.con = con;
	}
	
	public static Usuario inserir(Usuario usuario) {
		String sql = "insert into usuario (cpf_user,rg_user,cep_user,fk_upa) values (?,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, usuario.getCpf());
			ps.setInt(2, usuario.getRg());
			ps.setInt(3, usuario.getCpf());
			ps.setInt(4, usuario.getFkUpa());
			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public String alterar(Usuario usuario) {
		String sql = "update usuario set rg_user = ?, cep_user = ?, fk_upa = ?";
		sql += " where cpf_user = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getCpf());
			ps.setInt(2, usuario.getRg());
			ps.setInt(3, usuario.getCpf());
			ps.setInt(4, usuario.getFkUpa());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Usuario usuario) {
		String sql = "delete from usuario where cpf_user = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, usuario.getCpf());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso.";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public static ArrayList<Usuario> listarTodos() {
		String sql = "select * from usuario ";
		ArrayList<Usuario> listaUsuario	= new ArrayList<Usuario>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Usuario cb = new Usuario();
					cb.setCpf(rs.getInt(1));
					cb.setRg(rs.getInt(2));
					cb.setCep(rs.getInt(3));
					cb.setFkUpa(rs.getInt(4));
					listaUsuario.add(cb);
				}
				return listaUsuario;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			closeConnection();
		}
	}
}