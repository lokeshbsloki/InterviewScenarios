package com.openmrs;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.base.WaitUtils;

public class DeleteService extends BaseClass {

	
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
		boolean service = deleteService("Gynecology");
		System.out.println(service);
	}
	
	public boolean deleteService(String sname) {
		driver.findElement(By.xpath("//i[@id='appointmentschedulingui-delete-"+sname+"']")).click();
		
		//driver.findElement(By.xpath("//td[text()='"+sname+"']/following-sibling::td[3]/descendant::i[@title='Delete']")).click();
		
		driver.findElement(By.xpath("//div[@id='simplemodal-container']//child::button[@class='confirm right']")).click();
		return true;
		
	}
}
