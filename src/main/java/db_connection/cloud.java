package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
public class cloud {
	static String uname;
	static String pass;
	static int i=0;
	static WebDriver driver;
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException 
	{

		String host="db-eks-prod.cluster-ciulclnlzc5r.ap-south-1.rds.amazonaws.com"; // make sure your wamp/xamp server is running before running this program
		int port=3306;
		String db_username="admin";
		String db_password="9hfpuNkEuazDik2RLKXa";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/tkietgudexam"+ "?allowPublicKeyRetrieval=true&useSSL=FALSE",db_username, db_password);
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * FROM users where role='STUDENT' LIMIT 1");
		
		rs.next();
		
		 System.out.println(i);
		
		
		 
	}
		
	}
	