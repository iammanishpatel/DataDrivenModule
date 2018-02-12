package com.qa.project.ddm.main;

import java.io.IOException;
import org.testng.annotations.Test;
import com.qa.project.ddm.action.MultipleCSVData;
import com.qa.project.ddm.driver.DriverFactory;

public class Main {
	
	@Test(priority = 1)
	public void urlInitiation(){
		DriverFactory.init();
	}

	@Test(priority = 2)
	public void translatorSetUp() throws InterruptedException{
		MultipleCSVData.translatorSetUp();
	}
	
	@Test(priority = 3)
	public void readContent() throws IOException, InterruptedException{
		MultipleCSVData.readContent();
	}
}
