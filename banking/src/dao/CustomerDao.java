package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Customer;
import dto.DBConnector;

public class CustomerDao {
 public int insertCustomer(Customer c)
 {int x=0;
	 try 
	 {
	 DBConnector dbc=new DBConnector();
	 Connection con=dbc.start();
	 PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
	    ps.setString(1,c.getCname());
		ps.setString(2,c.getCadd());
		ps.setString(3,c.getCmob());
		ps.setString(4,c.getCemail());
		ps.setString(5,c.getAccno());
		ps.setString(6,c.getAccpass());
		ps.setDouble(7,c.getBalance());
		x= ps.executeUpdate();
	
	 }catch(SQLException ex)
	 {
		 System.out.println(ex);
	 }
	 return x;
}
//view customer here.....
public ArrayList<Customer> viewCustomer() {
	ArrayList<Customer> list=new ArrayList<>();
	try {
		DBConnector dbc=new DBConnector();
		Connection con=dbc.start();
		PreparedStatement ps=con.prepareStatement("select * from customer");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customer c=new Customer();
			c.setCname(rs.getString(1));
			c.setCadd(rs.getString(2));
			c.setCmob(rs.getString(3));
			c.setCemail(rs.getString(4));
			c.setAccno(rs.getString(5));
			c.setAccpass(rs.getString(6));
			c.setBalance(rs.getDouble(7));
			list.add(c);
		}
		
	}
	catch(SQLException ex)
	{
		System.out.println(ex);
	}
	return list;
}
// customer login check
public int check(String ac,String ap)
{
	int x=0;
	try
	{
		DBConnector dbc=new DBConnector();
		Connection con=dbc.start();
		PreparedStatement ps=con.prepareStatement("select * from customer where accno=? && accpass=?");
		ps.setString(1,ac);
		ps.setString(2,ap);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			x=1;
		}
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}

	return x;	
}

// fund transfer
public int fundTransfer(String to_acc,String from_acc,double amount)
{
	int x=0,y=0,z=0,flag=2;
	try {
		DBConnector dbc=new DBConnector();
		Connection con=dbc.start();
		PreparedStatement ps=con.prepareStatement("select balance from customer where accno=?");
		ps.setString(1,from_acc);
		ResultSet rs1=ps.executeQuery();
		while(rs1.next())
		{
		 if((rs1.getDouble("balance"))>amount)
		 {
			 PreparedStatement ps1=con.prepareStatement("update customer set balance=balance-? where accno=? ");
			 ps1.setDouble(1,amount);
			 ps1.setString(2,from_acc);
			 PreparedStatement ps2=con.prepareStatement("update customer set balance=balance+? where accno=?");
			 ps2.setDouble(1,amount);
			 ps2.setString(2, to_acc);
			 con.setAutoCommit(false);
			 y=ps1.executeUpdate();
			 z=ps2.executeUpdate();
			 con.commit(); 
			 if(y!=0 && z!=0)
					x=1;
			 
		 }
		 else {
			 x=2;
		 }
		}
	}catch(SQLException e)
	{
		System.out.println(e);
	}
	return x;
}
//loan application
public int loanApplication(String user,double lamount,String ltype,String date,String ldescription)
{
	int x=0;
	try {
		DBConnector dbc=new DBConnector();
		Connection con=dbc.start();
		PreparedStatement ps=con.prepareStatement("insert into loan_application values(?,?,?,?,?)");
		ps.setString(1,user);
		ps.setDouble(2, lamount);
		ps.setString(3,ltype);
		ps.setString(4, date);
		ps.setString(5,ldescription);
		x=ps.executeUpdate();
		
	}catch(SQLException e)
	{
		System.out.println(e);
	}
	
	return x;
}
// check loan
public ArrayList<Customer> checkLoan(String u)
{ 
	ArrayList<Customer> list=new ArrayList<>();

	try {
		DBConnector dbc=new DBConnector();
		Connection con=dbc.start();
		System.out.println(u);
		PreparedStatement ps=con.prepareStatement("select * from loan_application where accno=?");//select * from loan_application l,customer c where c.?=l.?
		ps.setString(1,u);
		//ps.setString(2,u);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customer c=new Customer();
			c.setAccno(rs.getString(1));
			c.setLamount(rs.getDouble(2));
			c.setLtype(rs.getString(3));
			c.setDate(rs.getString(4));
			c.setLdescription(rs.getString(5));
			list.add(c);
			
		}
		
	}catch(SQLException e)
	{
		System.out.println(e);
	}
	
	return list;
	
}
}