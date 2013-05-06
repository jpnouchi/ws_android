package com.joedayz.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.joedayz.model.Phone;
import com.joedayz.service.PhoneService;

/**
 * Servlet implementation class ServletPhone
 */
public class ServletPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession(true);
		PhoneService service=PhoneService.getInstance();
		String brand=request.getParameter("brand");
		String model=request.getParameter("model");
		System.out.println("brand "+brand);
		System.out.println("model "+model);
		Phone phone = new Phone(brand,model);
		String json="FAIL";
		if(service.get(phone)){			
		json = new Gson().toJson(phone);
		}
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

}
