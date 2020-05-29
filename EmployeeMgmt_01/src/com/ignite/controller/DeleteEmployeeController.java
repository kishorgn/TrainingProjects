package com.ignite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ignite.exception.EmployeeException;
import com.ignite.service.EmployeeDaoService;

/**
 * Servlet implementation class DeleteEmployeeController
 */
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String strId = req.getParameter("id");
		int id = Integer.parseInt(strId);
		EmployeeDaoService employeeDaoService = new EmployeeDaoService();
		try {
			if(employeeDaoService.delete(id)) {
				HttpSession session = req.getSession();
				session.setAttribute("delMsg", "Employee deleted successfully with id : "+id);
				res.sendRedirect("List.jsp");
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw new IOException("Exception occured during delete employee "+id, e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
