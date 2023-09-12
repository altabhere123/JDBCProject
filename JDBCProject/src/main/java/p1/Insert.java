package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Insert
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
			pstmt=con.prepareStatement("INSERT INTO SCHOOL VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Enter id");
			String ID=scan.next();
			/*stmt=con.createStatement();
			res=stmt.executeQuery("SELECT * FROM SCHOOL WHERE ID='"+ID+"'");    //=> to check whether an ID to be insert is already existed in the table
			String a =null;
			while(res.next())
			{
				a=res.getString(1);
			}
			if(ID.equals(a))
			{
				System.out.println("ID already exists");
			}
			else
			{ */
			System.out.println("Enter name");
			String NAME=scan.next();
			
			System.out.println("Enter Class");
			String CLASS=scan.next();
			
			System.out.println("Enter maths");
			int MATHS=scan.nextInt();
			
			System.out.println("Enter history");
			int HISTORY=scan.nextInt();
			
			System.out.println("Enter geography");
			int GEOGRAPHY=scan.nextInt();
			
			System.out.println("Enter polity");
			int POLITY=scan.nextInt();
			
			System.out.println("Enter indian_economy");
			int INDIAN_ECONOMY=scan.nextInt();
			
			System.out.println("Enter section");
			String SECTION=scan.next();
			
			int TOTAL= MATHS+HISTORY+GEOGRAPHY+POLITY+INDIAN_ECONOMY;
			double AVERAGE= (double)TOTAL/5;
			String div=null;
			if(AVERAGE>=60)
			{
				div="FIRST";
			}else if(AVERAGE>=45)
			{
				div="Second";
			}
			else if(AVERAGE>=33)
			{
				div="Third";
			} else
			{
				div="Fail";
			}
			
			pstmt.setString(1,ID);
			pstmt.setString(2,NAME);
			pstmt.setString(3,CLASS);
			pstmt.setInt(4,MATHS);
			pstmt.setInt(5,HISTORY);
			pstmt.setInt(6,GEOGRAPHY);
			pstmt.setInt(7,POLITY);
			pstmt.setInt(8,INDIAN_ECONOMY);
			pstmt.setString(9,SECTION);
			pstmt.setInt(10,TOTAL);
			pstmt.setDouble(11,AVERAGE);
			pstmt.setString(12,div);
				
			res=pstmt.executeQuery();
			System.out.println("Data insert success");
		}
		//}   //=> this bracket is the extension of checking an ID, whether existed or not
		catch(Exception e)
		{
			System.out.println("Data insert fail");
		}
	}
		}