package com.bookotrip.Bookotrip;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.UtilsTest;

public class BookoTrip {
	static WebDriver driver;
	Properties property1 = new Properties();
	

	@BeforeTest
	public void setup() throws IOException {
		FileInputStream stream1 = new FileInputStream(
				"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\Bookotrip\\resource\\testdata\\congif.properties");

		property1.load(stream1);

		String url = property1.getProperty("url");
		String browser = property1.getProperty("browserType");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\Bookotrip\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\Bookotrip\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ranjitha.selvam\\eclipse-workspace\\Bookotrip\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		driver.get(url);

	}
	@DataProvider(name="ranjitha")
	public Object[][] getDetails() throws IOException {
		String str="./resource/values/sheet1.xlsx";
		Object data[][] = UtilsTest.excel(str);
		return data;
	}

   @Test(dataProvider = "ranjitha")
	public void oneWayTest (String from, String to) throws IOException, InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"panel1\"]/div[1]/label[2]")).click();
		driver.findElement(By.id("txtFlyFrom")).sendKeys(from);
		driver.findElement(By.id("txtFlyTo")).sendKeys(to);
		driver.findElement(By.xpath("//*[@class=\"text-danger field-validation-valid\"]")).click();
		Thread.sleep(5000);

	}
	
	  @AfterTest
	  public void close() 
	  {
		  driver.close();
		  }
	 

	
	
}
