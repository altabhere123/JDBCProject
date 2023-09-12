package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Update 
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
			pstmt=con.prepareStatement("UPDATE SCHOOL SET GEOGRAPHY=? WHERE GEOGRAPHY=?"); // ......SET ID/NAME/MATH=? WHERE ID/NAME/MATH=?
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter new Subject");
			int newSubject=scan.nextInt();  //"int" =>for numerical value & "String" => for alphabetical name
			
			System.out.println("Enter old Subject");
			int oldSubject=scan.nextInt();
			
			pstmt.setInt(1,newSubject);
			pstmt.setInt(2,oldSubject);
			int row=pstmt.executeUpdate();
			System.out.println("Update Success");
		}
		catch(Exception e)
		{
			System.out.println("Update Failed");
		}
		try
		{
			pstmt=con.prepareStatement("UPDATE SCHOOL SET NAME=? WHERE NAME=?");
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter new Name");
			String newName=scan.nextLine(); // by Using "Line" this scanner will take all the value from that line only. so there is need for another scanner to load remaining values.
											// by using "Line" we can take a name having two or more words.
			Scanner scan1=new Scanner(System.in);  // two Scanner => so that they can load two(old and new names) 
			System.out.println("Enter old Name");
			String oldName=scan1.nextLine();
			
			pstmt.setString(1,newName);
			pstmt.setString(2,oldName);
			int row=pstmt.executeUpdate();
			System.out.println("Update Success");
		}
		catch(Exception e)
		{
			System.out.println("Update Failed");
		}
	}
}