package com.generalLearning;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.base.WaitUtils;

public class MultipleTabs extends BaseClass{

	@Test
	public void MultipleTabs() {

		driver.get("https://www.google.com");
		String window1 = driver.getWindowHandle();
		WaitUtils.wait(5);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open('about:blank','_blank');");
		Set<String> handles = driver.getWindowHandles();
		for(String win:handles) {
			if(!win.equals(window1)) {
				driver.switchTo().window(win);
				driver.get("https://crossbrowsertesting.com/blog/test-automation/how-to-handle-multiple-tabs-in-selenium-webdriver/");

				//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
				WaitUtils.wait(5);
				String title2 = driver.getTitle();
				System.out.println(title2);
			}
		}
		
		driver.switchTo().window(window1);
		String title = driver.getTitle();
		System.out.println(title);

	}



}
