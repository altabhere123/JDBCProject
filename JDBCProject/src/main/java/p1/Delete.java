package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Delete
{
	public static void main(String[] args) 
	{
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet res = null;
		Connection con=null;
		try
			{
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				System.out.println("Driver load success");
			}
		catch(Exception e)
		{
		System.out.println("Driver load fail");
		}
		try
		{
		con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
		  System.out.println("Connection success");
	  }
	  catch(Exception e)
	  {
		  System.out.println("Connection failed");
	  }
		try
		{
			pstmt=con.prepareStatement("DELETE FROM SCHOOL WHERE ID=?");
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter ID");
			String id=scan.next();
			pstmt.setString(1,id);
			int row=pstmt.executeUpdate();
			System.out.println("Delete Success");
		}
		catch(Exception e)
		{
			System.out.println("Delete fail");
		}
		}
		}