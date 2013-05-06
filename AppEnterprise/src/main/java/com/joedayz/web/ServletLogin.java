package com.joedayz.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.joedayz.model.BNUsuario;
import com.joedayz.service.UsuarioService;

public class ServletLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException {
		
		BNUsuario usuario= new BNUsuario();
		List<BNUsuario> users = new ArrayList<BNUsuario>();
		HttpSession session=request.getSession(true);
		UsuarioService servicio= new UsuarioService();
		
		String usu	= request.getParameter("username");
		String pass	= request.getParameter("password");
		
		try {
			usuario = servicio.login(usu, pass);
			users.add(usuario);
			String json = new Gson().toJson(users);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException ,IOException {
//		
//	}	
}
