package com.simplilearn.ph2.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.ph2.dao.ClassDao;

@WebServlet("/classDetails")
public class BackendAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassDao classDao;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		classDao = new ClassDao();
	}

	public void destroy() {
		System.out.println("destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		System.out.println("_______Inside doGet Handler");
		request.setAttribute("classDetails", classDao.getClassDetails());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
