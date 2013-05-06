package com.joedayz.dao.daoFactory;

import com.joedayz.dao.PhoneDao;
import com.joedayz.dao.UsuarioDao;

public abstract class DAOFactory {
	public static final int MYSQL = 1;

	public static final int ORACLE = 2;

	public static final int DB2 = 3;

	public static final int SQLSERVER = 4;

	public static final int XML = 5;

	public static final int POSTGRESQL = 6;
	
	public static final int H2 = 7;
	

	public abstract UsuarioDao getUsuarioDAO();
	
	public abstract PhoneDao getPhoneDao();

	
	public static DAOFactory getDAOFactory(int whichFactory) 
	{
		switch (whichFactory) 
		{
			case MYSQL:
			return new JdbcDAOFactory();
		
		default:
			return null;
		}
	}
}
