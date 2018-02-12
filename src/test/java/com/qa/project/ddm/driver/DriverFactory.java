package com.qa.project.ddm.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	static WebDriver driver;
	public static final String url = "https://translate.google.co.in/?um=1&ie=UTF-8&hl=en&client=tw-ob#hi/en/";
	
	public static void init(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\manishpatel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		if(driver==null){
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("Google translator opened");
		}
	}
	
	public static WebElement elementByXpath(String xpath){
		return driver.findElement(By.xpath(xpath));
	}
	
	public static void clickByXpath(String clickXpath){
		elementByXpath(clickXpath).click();
	}
	
	public static void sendKeysByXpath(String sendKeyXpath, String content){
		elementByXpath(sendKeyXpath).sendKeys(content);
	}
	
	public static String getTextByXpath(String getTextByXpath){
		return elementByXpath(getTextByXpath).getText();
	}
	
	public static void clearXpath(String clearXpath){
		elementByXpath(clearXpath).clear();
	}
	
}
