package com.qa.project.ddm.action;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.qa.project.ddm.driver.DriverFactory;

public class MultipleCSVData {
	
	public static final String path_csvDataSheet="src//test//java//com//qa//project//ddm//data//words.csv";
	

	public static void translatorSetUp() throws InterruptedException{
		String requiredLanguageMenuPath, requiredLanguagePath;
		requiredLanguageMenuPath = "//div[@id='gt-tl-gms']";
		requiredLanguagePath="//div[@id='gt-tl-gms-menu']/table/tbody/tr/td[6]/div[@id='goog-menuitem-group-6']/div[7]/div[@class='goog-menuitem-content' and contains(text(),'Spanish')]";
		DriverFactory.clickByXpath(requiredLanguageMenuPath);
		System.out.println("Clicked on Language Menu");
		Thread.sleep(500);
		DriverFactory.clickByXpath(requiredLanguagePath);
		System.out.println("Language Selected");
	}
	
	public static void readContent() throws IOException, InterruptedException{
		String path_input,path_translateButton,output,path_output;
		path_input = "//textarea[@id='source']";
		path_output = "//span[@id='result_box']";
		path_translateButton = "//input[@class='jfk-button jfk-button-action']";
		CSVReader reader = new CSVReader(new FileReader(path_csvDataSheet));// This will load csv file
		PrintWriter writer = new PrintWriter(new File("newList.csv"));
		StringBuilder sb = new StringBuilder();
		List<String[]> words = reader.readAll();
		System.out.println("total row size "+words.size());
		Iterator<String[]> itr = words.iterator();
		while(itr.hasNext()){
			String[] str=itr.next();
			System.out.println(" Words to be translated are :");
			for(int i=0;i<str.length;i++){
				 System.out.print(str[i]+" => ");
				 DriverFactory.clearXpath(path_input);
				 DriverFactory.sendKeysByXpath(path_input, str[i]);
				 DriverFactory.clickByXpath(path_translateButton);
				 output = DriverFactory.getTextByXpath(path_output);
				 System.out.println(output);
				 sb.append(output);
			     sb.append(", ");
				 Thread.sleep(500);
			}  	 
		}
		writer.write(sb.toString());
		reader.close();
		System.out.println("Done...");
	}
	
}
