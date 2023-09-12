package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Select 
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
			System.out.println("Students details are:");
			System.out.println("ID \tNAME	\tCLASS SECTION MATHS	HISTORY	GEOGRAPHY POLITY INDIAN_ECONOMY	TOTAL AVERAGE"); // => "\t"=> one tab space to adjust the space
			while(res.next()==true)
			{
				String a=res.getString(1);
				String b=res.getString(2);
				String c=res.getString(3);
				String d=res.getString(9);
				int e=res.getInt(4);
				int f=res.getInt(5);
				int g=res.getInt(6);
				int h=res.getInt(7);
				int i=res.getInt(8);
				float j=e+f+g+h+i;   //float=> so as to give the decimal value
				float k=j/5;// so as to give the decimal value
				String div=null;
				if(k>=60)
				{
					div="first";
				}else if(k>=45)
				{
					div="second";
				}else if(k>=33)
				{
					div="third";
				}
				else{
					div="fail";
				}
				System.out.println(a+"\t"+b+"\t\t"+c+"\t"+d+"\t"+e+"\t"+f+"\t"+g+"\t"+h+"\t"+i+"\t"+j+"\t"+k+"\t"+div); //"\t"=> one tab space to adjust the space in the output
			}
		}
			catch(Exception e)
			{
				System.out.println("Failed to collect data from database");
			}
		}
	}