package com.flipkart.tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.base.WaitUtils;

public class TC_scenario_01 extends BaseClass {


	@Test
	public void scenario01() {

		driver.get("https://www.flipkart.com/");
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ESCAPE);
		WaitUtils.wait(3);
		act.build().perform();

		String parent = driver.getWindowHandle();

		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
		.sendKeys("iphone xr");

		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();

		String text1 = driver.findElement(By.xpath("//span[@class='_2yAnYN']")).getText();
		String[] text2 = text1.split(" ");

		int count = Integer.parseInt(text2[3]);
		System.out.println(count);
		List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='_1HmYoV _35HD7C'])[2]//child::div[@class='_3O0U0u']"));
		
		int count2 = elements.size();
		System.out.println(count2);
		Assert.assertEquals(count, count2);

		WebElement mobile = driver.findElement(By.xpath("((//div[@class='_1HmYoV _35HD7C'])[2]//child::div[@class='_3O0U0u'])[1]//child::div[@class='_3wU53n']"));
		String redmi = mobile.getText();
		System.out.println(redmi);
		mobile.click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String win:windows) {
			if(!win.contains(parent)) {
				driver.switchTo().window(win);
			}
		}
		WebElement mobile2 = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
		mobile2.click();
		WaitUtils.wait(5);

		String text3 = driver.findElement(By.xpath("//a[@class='_325-ji _3ROAwx']")).getText();
		System.out.println(text3);

		Assert.assertEquals(text3, redmi);
	}

}
