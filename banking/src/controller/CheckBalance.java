package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Customer;
import dto.DBConnector;

/**
 * Servlet implementation class CheckBalance
 */
@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
		DBConnector dbc=new DBConnector();
	Connection con=dbc.start();
	HttpSession ss=request.getSession();
	String ac=(String)ss.getAttribute("acc no");
	//System.out.println(ac);
	PreparedStatement ps=con.prepareStatement("select balance from customer where accno=?");
	ps.setString(1,ac);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		double bal=rs.getDouble("balance");
		RequestDispatcher rd=request.getRequestDispatcher("BalanceInfo.jsp");
		request.setAttribute("msg",bal);
		rd.forward(request, response);
	}
	}catch(SQLException e)
	{
		System.out.println(e);
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
