package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.DBConnector;

public class ManagerLoginDao {
public int check(String u,String p)
{
	int x=0;
	try 
	{
		DBConnector dbc=new DBConnector();
		Connection con=dbc.start();
		PreparedStatement ps=con.prepareStatement("select * from manager where mid=? && mpass=?");
		ps.setString(1,u);
		ps.setString(2,p);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			x=1;
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return x;
}
}
