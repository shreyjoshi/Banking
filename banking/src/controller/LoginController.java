package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerLoginDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
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
	String u=request.getParameter("mid");
	String p=request.getParameter("mpass");
	ManagerLoginDao mld=new ManagerLoginDao();
	int y=mld.check(u,p);
	if(y==1)
	{
		response.sendRedirect("ManagerAdmin.jsp");
	}
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("Bank.html");
		request.setAttribute("msg","Enter Valid User id and Password!!!");
		rd.forward(request,response);
	}
	}

}
