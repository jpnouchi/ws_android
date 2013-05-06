package com.joedayz.service;

import com.joedayz.dao.PhoneDao;
import com.joedayz.dao.daoFactory.DAOFactory;
import com.joedayz.model.Phone;

public class PhoneService {

	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	PhoneDao phoneDao=daoFactory.getPhoneDao();
	private static PhoneService instance ;
	private PhoneService() {
		// TODO Auto-generated constructor stub
	}
	public static PhoneService getInstance(){
			
			return ((instance==null)?new PhoneService():instance);
	}
	
	public boolean save(Phone phone){
		phoneDao.save(phone);
		return (phone.getId()>0 ?true:false);
	}
	
	public boolean get(Phone phone){
		phoneDao.get(phone);
		return (phone.getId()>0 ?true:false);
	}
}
