package com.joedayz.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joedayz.dao.UsuarioDao;
import com.joedayz.dao.daoFactory.BaseDaoSupport;
import com.joedayz.model.BNUsuario;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private BaseDaoSupport daoSupport= new BaseDaoSupport();

	@SuppressWarnings("static-access")
	public BNUsuario login(String username, String password) throws SQLException {
		PreparedStatement pstm=null;
		Connection con=null;
		ResultSet rs=null;
		BNUsuario user=null;
		
		try{
			con = daoSupport.getConnexion();
			StringBuilder query = new StringBuilder();
			query.append("select  u.co_user as COUSER, ");
			query.append(" u.username as USERNAME,  ");
			query.append("u.password as PASS,  ");
			query.append(" u.email as EMAIL ");
			query.append("FROM m_user u ");
			query.append("WHERE u.username='").append(username).append("'");
			query.append("AND   u.password='").append(password).append("'");
			
			pstm = (PreparedStatement) con.prepareStatement(query.toString());
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				user = new BNUsuario();
				user.setCoUser(rs.getLong("COUSER"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASS"));
			}
			
			
		}catch(SQLException e){
			rs.close();
			pstm.close();
			con.close();
		}
		rs.close();
		pstm.close();
		con.close();
		return user;
	}

	public List<BNUsuario> listadoUsuarios() throws SQLException {
		List<BNUsuario> usuarios =  new ArrayList<BNUsuario>();
		PreparedStatement pstm=null;
		Connection con=null;
		ResultSet rs=null;
		BNUsuario user=null;
		
		try{
//			con = daoSupport.getConnexion();
			con=BaseDaoSupport.getConnexion();
			StringBuilder query = new StringBuilder();
			query.append("select  u.co_user as COUSER, ");
			query.append(" u.username as USERNAME,  ");
			query.append("u.password as PASS,  ");
			query.append(" u.email as EMAIL ");
			query.append("FROM m_user u ");
			
			pstm = (PreparedStatement) con.prepareStatement(query.toString());
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				user = new BNUsuario();
				user.setCoUser(rs.getLong("COUSER"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASS"));
				usuarios.add(user);
			}
			
			
		}catch(SQLException e){
			rs.close();
			pstm.close();
			con.close();
		}
		rs.close();
		pstm.close();
		con.close();
		return usuarios;
	}
	
	
	
}
