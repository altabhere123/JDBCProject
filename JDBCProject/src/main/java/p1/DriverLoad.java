package p1;
import java.sql.DriverManager;

public class DriverLoad 
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
	}
}
