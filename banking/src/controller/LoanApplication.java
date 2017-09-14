package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

/**
 * Servlet implementation class LoanApplication
 */
@WebServlet("/LoanApplication")
public class LoanApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession();
		String user=(String)ss.getAttribute("acc no");
		double lamount=Double.parseDouble(request.getParameter("lamount"));
		String ltype=request.getParameter("ltype");
		String ldescription=request.getParameter("ldescription");
		Date d=new Date();
		String date=d.toString();
		CustomerDao cd=new CustomerDao();
		int y=cd.loanApplication(user,lamount,ltype,date,ldescription);

		if(y==1)
		{
			System.out.println("hello");
			RequestDispatcher rd=request.getRequestDispatcher("loanApplied.jsp");
			request.setAttribute("loan_status", "loan succesfully applied");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("loanApplied.jsp");
			request.setAttribute("loan_status", "loan application failed");
			rd.forward(request,response);
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
