package hellocucumber;

import io.cucumber.java.en.*;
import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.runtime.Timeout;

public class StepDefinitions {
	
	WebDriver driver;
	public StepDefinitions() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver");
		driver  = new ChromeDriver();
	}
	
    @Given("A browser and technical challenge application UI")
    public void anExampleScenario() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();			
        driver.get("http://localhost:8080");
    }

    @When("Dispense now button is clicked")
    public void allStepDefinitionsAreImplemented() {
    	try {
  		  Thread.sleep(5000);
  		} catch (InterruptedException ex) {
  		  ex.printStackTrace();
  		}
    	driver.findElement(By.linkText("Dispense Now")).click();	
    }

    @Then("Cash dispensed page opens up")
    public void theScenarioPasses() {
    	try {
  		  Thread.sleep(5000);
  		} catch (InterruptedException ex) {
  		  ex.printStackTrace();
  		}
    	String text = driver.findElement(By.className("display-4")).getText();
    	Assert.assertEquals(text, "Cash dispensed");
        driver.quit();  
    }

}
