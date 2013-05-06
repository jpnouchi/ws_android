package com.joedayz.dao.daoFactory;

import java.sql.*;

public class BaseDaoSupport {
	
	private static String driver = null;
	private static String usuario = null;
	private static String password = null;
	private static String url = null;

	static {
		try {
			url =  "jdbc:mysql://localhost:3306/json";
			driver = "com.mysql.jdbc.Driver";
			usuario =  "root";
			password = "root";

			Class.forName(driver);

		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
	
  public static Connection getConnexion() throws SQLException{
	  Connection connection = null;
	  try {
	
//		connection  = DriverManager.getConnection("jdbc:mysql://192.168.0.150:3306/json","root","root");
		connection  = DriverManager.getConnection(url,usuario,password);
		System.out.println("Conecto");
	  }	 catch (SQLException e) {
		System.out.println("Error de Conexion "+e);
	  }
	  return connection;
}
}