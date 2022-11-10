package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class localhost {
	static String uname;
	
	
static WebDriver driver;
	
	public static void login() {
		
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get("https://exam.msbte.ac.in/oexam/outer.php");
		    driver.findElement(By.linkText("Log In")).click();
		    driver.findElement(By.id("username1")).sendKeys(uname);
		       
		
	}
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException 
	{

		String host="localhost"; // make sure your wamp/xamp server is running before running this program
		int port=3306;
		String db_username="root";
		String db_password="";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/test",db_username, db_password);
		
		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("select * FROM users where uid='1'");

		rs.next();	//to move forward to next index, initial it is in zero index

		
		uname=rs.getString("username");
		System.out.println("USERNAME is "+uname);
		

		
		
		login();
	}
	
	
	
	

}
