package dao;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.joedayz.dao.UsuarioDao;
import com.joedayz.dao.daoFactory.BaseDaoSupport;
import com.joedayz.dao.daoFactory.DAOFactory;
import com.joedayz.dao.impl.UsuarioDaoImpl;
import com.joedayz.model.BNUsuario;

@RunWith(JUnit4.class)
public class TestDAOFactory {

	private BaseDaoSupport daoSupport= new BaseDaoSupport();
	DAOFactory fabrica 	  = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UsuarioDao usuarioDao = fabrica.getUsuarioDAO(); 
	
	@SuppressWarnings("static-access")
//	@Test
//	public void TestConexion() throws Exception{
//		Connection conection = daoSupport.getConnexion();
//		conection.close();
//	}
	
	@Test
	public void TestLogin() throws Exception{
		String username="ssnova24";
		String password="123456";
		BNUsuario user = new BNUsuario();
		user = usuarioDao.login(username, password);
		System.out.println("nombre: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
	}
	
	
}
