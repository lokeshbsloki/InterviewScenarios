package com.openmrs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.base.WaitUtils;

public class RealTimeScenarios extends BaseClass {

	
	@Test
	public void TC_01() {
		
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		
		//driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//a[@id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']")).click();

		WaitUtils.wait(3);
		
		driver.findElement(By.xpath("//a[@id='appointmentschedulingui-manageAppointmentTypes-app']")).click();
		boolean service = verifyService("rology");
		System.out.println(service);
		
	}
	
	public boolean verifyService(String sname) {
		
		List<WebElement> pagelist = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
		
		List<WebElement> tablelist = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		
		boolean res=false;
		outerloop:
		for(int i=1;i<pagelist.size();i++) {
			
			for(int j=0;j<tablelist.size();j++) {
				
				if(tablelist.get(j).getText().equals(sname)) {
					
					System.out.println("service is available");
					res=true;
					break outerloop;
				}
				
			}
			pagelist = driver.findElements(By.xpath("//div[@id='appointmentTypesTable_paginate']/span/a"));
			pagelist.get(i).click();
			tablelist = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));
		}
		
		return res;	
	}
}
