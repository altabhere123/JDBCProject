package p1;
import java.sql.Connection;
import java.sql.DriverManager;

public class DriverLoadandConnection 
{
	public static void main(String[] args) 
	{
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
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
	  System.out.println("Connection success");
  }
  catch(Exception e)
  {
	  System.out.println("Connection failed");
  }
	}
	}
