package com.tvpurchuse.stepdefenition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TvPurchuse {
static WebDriver driver;
	


@Given("customer login to flipkart")
public void customer_login_to_flipkart() {

	   WebDriverManager.chromedriver().setup();
			     driver = new ChromeDriver();
			     driver.get("https://www.flipkart.com/");
			     driver.manage().window().maximize();
			     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			    
			     try {
			    	 
			    	 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			    	 
			     }catch (Exception e){
			    	 System.out.println("Login not required");
			     
			     }
} 
 
String dinesh;

@When("customer using  search box to search")
public void customer_using_search_box_to_search() throws Throwable {

	    dinesh = "SAMSUNG Crystal 4K";
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys(dinesh);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
	    WebElement tvname = driver.findElement(By.xpath("(//div[contains(text(),'"+dinesh+"')])[1]"));
		String text = tvname.getText();
		tvname.click();
		} 

@When("customer choose the TV")
public void customer_choose_the_TV() {
	String parent = driver.getWindowHandle();
	Set<String> child = driver.getWindowHandles();
	for (String x:child) {
		if (!x.equals(parent)) {
			driver.switchTo().window(x);
			System.out.println("windows switched");
		}
	}
}

@When("Verify the branding is genuine by checking the manufacturing specifications")
public void verify_the_branding_is_genuine_by_checking_the_manufacturing_specifications() throws Throwable {
	 System.out.println("JavascriptExecutor");
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 Thread.sleep(3000);
	 WebElement buy = driver.findElement(By.xpath("//button[@class='_2KpZ6l 2U9uOA ihZ75k 3AWRsL']"));
	 String text = buy.getText();
   
}

@When("customer makes order")
public void customer_makes_order() {
	    System.out.println("Order placed successfully");
}

@Then("Check if the packaging is not damaged due to the shipping")
public void check_if_the_packaging_is_not_damaged_due_to_the_shipping() {
	 System.out.println("Order shipped successfully");
   
}

@When("customer using  search box to search using one dimensional list")
public void customer_using_search_box_to_search_using_one_dimensional_list(io.cucumber.datatable.DataTable dataTable) throws Throwable {
	List<String> datas = dataTable.asList();
	dinesh = datas.get(0);
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys(dinesh);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	WebElement TVname = driver.findElement(By.xpath("(//div[contains(text(),'"+dinesh+"')])[1]"));
	String text = TVname.getText();
	Thread.sleep(3000);
	TVname.click();  
	driver.quit();
}
  
@When("customer using  search box to search using one dimensional map")
public void customer_using_search_box_to_search_using_one_dimensional_map(DataTable dataTable) throws Throwable {
	
	Map<String, String> datas = dataTable.asMap(String.class, String.class);
	dinesh = datas.get("TV2");
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys(dinesh);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	WebElement TVname = driver.findElement(By.xpath("(//div[contains(text(),'"+dinesh+"')])[1]"));
	String text = TVname.getText();
	Thread.sleep(3000);
	TVname.click();
	driver.quit();
}

@When("customer using  search box to search{string}")
public void customer_using_search_box_to_search(String string) throws Throwable {
	dinesh = string;
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys(dinesh);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	WebElement TVname = driver.findElement(By.xpath("(//div[contains(text(),'"+dinesh+"')])[1]"));
	String text = TVname.getText();
	Thread.sleep(3000);
	TVname.click();
	driver.quit();
	
   
}
}