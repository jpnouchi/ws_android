package com.joedayz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.joedayz.dao.PhoneDao;
import com.joedayz.dao.daoFactory.BaseDaoSupport;
import com.joedayz.model.Phone;

public class PhoneDaoImpl implements PhoneDao {
	
//	private BaseDaoSupport daoSupport= new BaseDaoSupport();

	public void save(Phone phone) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;


		try {
			conn = BaseDaoSupport.getConnexion();
			StringBuilder sql=new StringBuilder();
			sql.append("INSERT INTO phone (manufacturer,brand,model,release,os,osVersion,processor,memory) ");
			sql.append("VALUES(?,?,?,?,?,?,?,?)");
			pstm = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);			
			pstm.setString(1,phone.getManufacturer());
			pstm.setString(2,phone.getBrand());
			pstm.setString(3,phone.getModel());
			pstm.setString(4,phone.getRelease());
			pstm.setString(5,phone.getOs());
			pstm.setString(6,phone.getOsVersion());
			pstm.setString(7,phone.getProcessor());
			pstm.setString(8,phone.getMemory());
			pstm.executeUpdate();
			ResultSet keys = pstm.getGeneratedKeys();
			if(keys.next()){
				int idGenerado = keys.getInt(1);
				phone.setId(idGenerado);
			}
			System.out.println("Phone"+phone);

		}catch (SQLException e) {
			throw new RuntimeException(e.getSQLState());
		}finally{
			
				try {
					if(pstm!=null)pstm.close();	
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void get(Phone phone) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;
		
		try {
			conn = BaseDaoSupport.getConnexion();
			pstm=conn.prepareStatement("select id,manufacturer,brand,model,`release`,os,osVersion,dateCreate,userCreate from phone where brand=? and model =?");
			pstm.setString(1,phone.getBrand());
			pstm.setString(2,phone.getModel());
			System.out.println("query "+pstm.toString());
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()){
				phone.setId(rs.getInt("id"));
				phone.setManufacturer(rs.getString("manufacturer"));
				phone.setRelease(rs.getString("release"));
				phone.setOs(rs.getString("os"));
				phone.setOsVersion(rs.getString("osVersion"));
				phone.setDateCreate(rs.getString("dateCreate"));
				phone.setUserCreate(rs.getString("userCreate"));
			}
			System.out.println("Phone :\n"+phone);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(pstm != null){
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	}
		
	
	

}
