package com.ignite.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ignite.beans.Employee;
import com.ignite.exception.EmployeeException;
import com.ignite.service.EmployeeDaoService;

/**
 * Servlet implementation class AddEmployeeController
 */
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String strDeptno = req.getParameter("deptno");
		int deptno = Integer.parseInt(strDeptno);
		String strBsal = req.getParameter("bsal");
		double bsal = Double.parseDouble(strBsal);
		
		try {
			Employee employee = new Employee(name, dob, deptno, bsal);
			EmployeeDaoService employeeDaoService = new EmployeeDaoService();
			int empid = employeeDaoService.save(employee);
			HttpSession session = req.getSession();
			session.setAttribute("empid", empid);
			res.sendRedirect("List.jsp");
//			RequestDispatcher requestDispatcher = req.getRequestDispatcher("List.jsp");
//			requestDispatcher.forward(req, res);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new IOException("Invalid format of DoB", e);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			throw new IOException("Exception occured ", e);
		}
		
	}

}
