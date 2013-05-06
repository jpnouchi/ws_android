package com.joedayz.dao;

import java.sql.SQLException;
import java.util.List;

import com.joedayz.model.BNUsuario;

public interface UsuarioDao {

	public BNUsuario login(String username, String password) throws SQLException;
	public List<BNUsuario> listadoUsuarios() throws SQLException;
}
