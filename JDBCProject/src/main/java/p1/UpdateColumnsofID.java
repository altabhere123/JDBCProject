package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateColumnsofID 
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
			stmt=con.createStatement();
			res=stmt.executeQuery("SELECT * FROM SCHOOL"); //..(... SCHOOL WHERE ID='A1'");=>To find the details of an student..
			System.out.println("Execute query success");
		}
		catch(Exception e)
		{
			System.out.println("Execute query failed");
		}
		try
		{
			pstmt=con.prepareStatement("UPDATE SCHOOL SET MATHS=?, HISTORY=?, GEOGRAPHY=?, POLITY=?, INDIAN_ECONOMY=?, TOTAL=?, AVERAGE=?, DIVISION=? WHERE ID=?"); // ......SET ID/NAME/MATH=? WHERE ID/NAME/MATH=?
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Enter ID");
			String ID=scan.next();
			
			System.out.println("Enter MATHS mark");
			int maths=scan.nextInt();

			System.out.println("Enter HISTORY mark");
			int history=scan.nextInt();

			System.out.println("Enter GEOGRAPHY mark");
			int geography=scan.nextInt();
			
			System.out.println("Enter POLITY mark");
			int polity=scan.nextInt();
			
			System.out.println("Enter INDIAN_ECONOMY mark");
			int economy=scan.nextInt();
			int TOTAL=maths+history+geography+polity+economy;
			double AVERAGE=(double)TOTAL/5;
			String div=null;
			if(AVERAGE>=60)
			{
				div="First";
			}
			else if(AVERAGE>=45)
			{
				div="Second";
			}
			else if(AVERAGE>=33)
			{
				div="Third";
			}
			else
			{
				div="Fail";
			}
			pstmt.setInt(1,maths);
			pstmt.setInt(2,history);
			pstmt.setInt(3, geography);
			pstmt.setInt(4, polity);
			pstmt.setInt(5, economy);
			pstmt.setInt(6,TOTAL);
			pstmt.setDouble(7, AVERAGE);
			pstmt.setString(8, div);
			pstmt.setString(9, ID);
			
			int row=pstmt.executeUpdate();
			System.out.println("Update Success");
		}
		catch(Exception e)
		{
			System.out.println("Update Failed");
		}
	}
}