package Test;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class TestBookMyShoww {
	
		private WebDriver driver;
		private String baseUrl;
		@Before
		public void setUp() throws Exception {
			BufferedReader bf = new BufferedReader(new FileReader("D:\\Shruti\\Workspace\\BookMyShow\\Input"));
			StringBuilder str = new StringBuilder();
			String line = bf.readLine();
			while(line != null) {
				str.append(line);
				str.append(System.lineSeparator());
				line = bf.readLine();
			}
			baseUrl = str.toString();
			//System.out.println(new File(".").getAbsolutePath());
			System.setProperty("webdriver.chrome.driver","D:\\Driverss\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
		}
		
		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void test() throws InterruptedException, IOException {
			FileWriter fw = new FileWriter("Results.txt");
			//To get into the Website
			driver.get(baseUrl);
			//To decline the notification
			driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
			//String strFile = "data.xls";
			String st = ReadCellData(3,0);
			driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input")).sendKeys(st);
			driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[1]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
			//Go to the movies tab
			driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]")).click();
			//Go to explore upcoming movies
			//driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/a/div/div[2]/div/img")).click();
			driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[3]/div/div/div[2]/a/div/div[2]/div/img")).click();
			//Click on the first movie in the list
			driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div[4]/div/div/div[2]/a[2]/div/div[2]/div/img")).click();
			//Writing movie name on the Console
			System.out.println("City :- "+st);
			//Writing movie name in the text file
			fw.write("City Search :-"+st);
			//To get the movie name
			String movieName = driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/section[1]/div/div/div[2]/h1")).getText();
			//To write the movie name in text file
			fw.write("\n"+movieName+" - Pass");
			//To print movie name in console
			System.out.println(movieName);
			//About the movie in console
			System.out.println("About the movie:-");
			//Fetching data from webpage and printing it on console
			System.out.println(driver.findElement(By.xpath("//*[@id=\"component-1\"]/section/span/div/span")).getText());
			//Fetching data from webpage and printing it in text file
			String info = driver.findElement(By.xpath("//*[@id=\"component-1\"]/section/span/div/span")).getText();
			fw.write("\n"+info);
			fw.close();
			
			//driver.close();
		}
		// Reading data from excel file
		
		public String ReadCellData(int vRow,int vCol) {
			String value = null;
			HSSFWorkbook wb = null;
			try {
				FileInputStream fs = new FileInputStream("data.xls");
				wb = new HSSFWorkbook(fs);
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(IOException e1) {
				e1.printStackTrace();
			}
			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
			Row row1 = sheet.getRow(vRow);
			Cell cell = row1.getCell(vCol);
			value = cell.getStringCellValue();
			return value;
			
			
		}
		S
	}
		 
	


