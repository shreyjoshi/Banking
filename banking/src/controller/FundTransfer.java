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

/**
 * Servlet implementation class FundTransfer
 */
@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss=request.getSession();
		
		String from_acc=(String) ss.getAttribute("acc no");
		String to_acc=request.getParameter("to_acc");
		double amount=Double.parseDouble(request.getParameter("amount"));
		CustomerDao cd=new CustomerDao();
		int result= cd.fundTransfer(to_acc,from_acc,amount);
		if(result==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("FundTransfer.jsp");
			request.setAttribute("status", "Congratulations amount"+amount+" successfully transacted to"+to_acc);
			rd.forward(request,response);
		}
		else if(result==2) {
			RequestDispatcher rd=request.getRequestDispatcher("FundTransfer.jsp");
			request.setAttribute("status","insufficient balance");
			rd.forward(request, response);		
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("FundTransfer.jsp");
			request.setAttribute("status","transfer to"+to_acc+"failed");
			rd.forward(request, response);		
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
