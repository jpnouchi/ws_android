package com.joedayz.service;

import java.sql.SQLException;
import java.util.List;

import com.joedayz.dao.UsuarioDao;
import com.joedayz.dao.daoFactory.DAOFactory;
import com.joedayz.model.BNUsuario;

public class UsuarioService {

	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDao usuarioDao = daoFactory.getUsuarioDAO();
	
	public BNUsuario login(String username, String password) throws SQLException{
		return usuarioDao.login(username, password);
	}
	
	public List<BNUsuario> listadoUsuarios() throws SQLException{
		return usuarioDao.listadoUsuarios();
	}
	
}
