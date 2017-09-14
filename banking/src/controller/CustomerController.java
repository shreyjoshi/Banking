package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import dao.CustomerDao;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname	=request.getParameter("cname");
		String cadd		=request.getParameter("cadd");
		String cmob		=request.getParameter("cmob");
		String cemail	=request.getParameter("cemail");
		String accno	=request.getParameter("accno");
		String accpass	=request.getParameter("accpass");
		Double balance	=Double.parseDouble(request.getParameter("balance"));
		
		Customer c=new Customer(cname,cadd,cmob,cemail,accno,accpass,balance);
	
		CustomerDao cd=new CustomerDao();

			int y=cd.insertCustomer(c);
			if(y==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("createCustomer.jsp");
				request.setAttribute("msg","Registration Successfull");
				rd.forward(request, response);
			}
		
	}

}
