package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import jxl.Cell;

import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class TestBookMyShow {
		private WebDriver driver;
		private String baseURL;
		
	
	@Before
	public void setUp() throws Exception {
		
		  BufferedReader bf = new BufferedReader(new FileReader("D:\\Shruti\\Workspace\\BookMyShow\\Config\\input.txt"));
		  StringBuilder str = new StringBuilder();
		  String line = bf.readLine();
		  while(line!= null) {
		   str.append(line);
		   str.append(System.lineSeparator()); 
		   line = bf.readLine();
	   }
		 baseURL = str.toString();
	     System.out.println(baseURL);
	     //System.out.println(new File(".").getAbsolutePath());
	     System.setProperty("webdriver.chrome.driver","D:\\Driverss\\chromedriver.exe");
	     driver = new ChromeDriver();
	     // driver.manage().window().maximize
	   
	   driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	 } 
  
	@Test
	public void test() throws InterruptedException , IOException {
		FileWriter fw = new FileWriter("Results.txt");
		//To go to the Website
		System.out.println(baseURL);
		driver.get(baseURL);
		//To decline the notification
		driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
		//String strFile="search_city.xls";
		String st = ReadCellData(1,0);   // HA_GA_readXL(1,strFile);
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input")).sendKeys("Delhi");
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div[1]//div[1]/input")).sendKeys(Keys.Down);
		//Selected city as Delhi
	    //driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[1]/div/span")).click();
		//Go to sign page
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/div[1]")).click();
		//Entering phone number to sign in
		driver.findElement(By.id("Mobile number")).sendKeys("8055001761");
		//Click on continue
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(40000);
		//click on  movies
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]")).click();
		//click on upcoming movies
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/a/div/div[2]/div/img")).click();
		
		driver.findElement(By.xpath("/*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div[4]/div/div/div[2]/a[1]/div/div[3]/div[1]/div")).click();
		System.out.println("City :-"+st);
		fw.write("City Search :- "+st);
		WebElement movieName = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/section[1]/div/div/div[2]/h1"));
		fw.write("\n"+movieName+" - Pass");
		System.out.println("Movie Name:- "+driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/section[1]/div/div/div[2]/h1")));
	    System.out.println("About the movie:-");
	    System.out.println(driver.findElement(By.xpath(//*[@id="component-1"]/section/span/div/span)).getText();
        String WebElement info = driver.findElement(By.xpath("//*[@id=\"component-1\"]/section/span/div/span"));
        fw.write("\n"+info);
        fw.close();
        driver.close();
	}
	private CharSequence Keys() {
		// TODO Auto-generated method stub
		return null;
	}

	private String ReadCellData(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@After
   public void test1() throws InterruptedException, Exception {
}






