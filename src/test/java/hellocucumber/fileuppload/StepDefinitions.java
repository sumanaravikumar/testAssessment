package hellocucumber.fileuppload;

import io.cucumber.java.en.*;
import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinitions {
	
	WebDriver driver;
	int totalRecords;
	
	public StepDefinitions() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		driver  = new ChromeDriver();
	}
	
    @Given("an example scenario1")
    public void anExampleScenario() {
        driver.manage().window().maximize();			
        driver.get("http://localhost:8080");
    }

    @When("all step definitions are implemented1")
    public void allStepDefinitionsAreImplemented() {    	
    	WebElement chooseFile = driver.findElement(By.className("custom-file-input"));
    	chooseFile.sendKeys(System.getProperty("user.dir") + "/test1.csv");
    	List<WebElement> elements = driver.findElements(By.tagName("tr"));
    	this.totalRecords  = elements.size()-1;
    }

    @Then("the scenario passes1")
    public void theScenarioPasses() {
    	try {
  		  Thread.sleep(5000);
  		} catch (InterruptedException ex) {
  		  ex.printStackTrace();
  		}
    	driver.findElements(By.tagName("button")).get(0).click();
    	List<WebElement> elements = driver.findElements(By.tagName("tr"));
    	System.out.println("Old Count = " + this.totalRecords + " , New Count = " + (elements.size()-1));
    	Assert.assertEquals(elements.size()-1, this.totalRecords+5);
        driver.quit();
    }
}