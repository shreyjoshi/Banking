package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.ManagerLoginDao;

/**
 * Servlet implementation class LoginControllerCustomer
 */
@WebServlet("/LoginControllerCustomer")
public class LoginControllerCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ac=request.getParameter("accno");
		String ap=request.getParameter("accpass");
		CustomerDao cd=new CustomerDao();
		int y=cd.check(ac,ap);
		if(y==1)
		{
			System.out.println(ac);
			HttpSession ss=request.getSession();
			ss.setAttribute("acc no",ac);
			response.sendRedirect("CustomerHome.jsp");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Bank.html");
			request.setAttribute("msg","Enter Valid User id and Password!!!");
			rd.forward(request,response);
		}
	}

}
