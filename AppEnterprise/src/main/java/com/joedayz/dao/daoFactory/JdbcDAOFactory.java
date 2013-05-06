package com.joedayz.dao.daoFactory;

import com.joedayz.dao.PhoneDao;
import com.joedayz.dao.UsuarioDao;
import com.joedayz.dao.impl.PhoneDaoImpl;
import com.joedayz.dao.impl.UsuarioDaoImpl;



public class JdbcDAOFactory extends DAOFactory{
	
	public UsuarioDao getUsuarioDAO() {
		return new UsuarioDaoImpl();
	}

	@Override
	public PhoneDao getPhoneDao() {
		// TODO Auto-generated method stub
		return new PhoneDaoImpl();
	}




}
