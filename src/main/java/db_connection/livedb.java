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

public class livedb {
	static String uname;
	static String pass;
	static int i=0;
	static WebDriver driver;
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException 
	{

		String host="192.169.226.38"; // make sure your wamp/xamp server is running before running this program
		int port=3306;
		String db_username="vtplapps";
		String db_password="Vm007009!@#$";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/ss_acmon_s_21_22",db_username, db_password);
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * FROM users where role='INST'");
		
		rs.next();
		
		while(rs.next()) {
			
			uname=rs.getString("username");
			pass=rs.getString("orig_pass");
			System.out.println("USERNAME is "+uname);
			System.out.println("PASSWORD is "+pass);
			
			
			login(uname,pass); // Login Method Called Here
			
			
			i++;	
			
		}
		 System.out.println(i);
		
		
		 
		
		
	}
	
	public static void login(String uname, String pass) {
		
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    
		    driver.get("https://exam.msbte.ac.in/oexam/outer.php");
		    driver.findElement(By.linkText("Log In")).click();
		    driver.findElement(By.id("username1")).sendKeys(uname);
		    driver.findElement(By.id("password1")).sendKeys(pass);
		    
		    String no1 = driver.findElement(By.id("num1")).getAttribute("value"); // Getting capthch value 1
			int nu1 = Integer.parseInt(no1);
		 
		  	String no2 = driver.findElement(By.id("num2")).getAttribute("value"); // Getting capthch value 2
		  	int nu2 = Integer.parseInt(no2);
		  
		  	int sum = nu1 + nu2;  
		   
		  
		  driver.findElement(By.xpath("//*[@id=\"captcha\"]")).sendKeys(""+sum);  // enter addition of two numbers in captcha
		  
		  driver.findElement(By.xpath("/html/body/div/font/div[1]/div/div[2]/div/div/div/center/form/div/div/center[2]/input")).click();
		
		  driver.findElement(By.xpath("/html/body/font/nav/div/div/ul/li[2]/a/span/font/strong")).click();
		  
		  driver.close();
		 
		  
		  
		       
		
	}
}
