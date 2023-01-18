package hellocucumber.fileuppload.notallcolumns;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.io.File;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import static io.restassured.RestAssured.given;

public class StepDefinitions {
	
	Response response;
	
    @Given("CSV File upload functionality")
    public void anExampleScenario() {
    	RestAssured.baseURI = "http://localhost:8080";
    }

    @When("A CSV file is uploaded with lesser number of columns is uploaded")
    public void allStepDefinitionsAreImplemented() {
    	File testFile = new File(System.getProperty("user.dir")+ "/lesscolumns.csv");
    	response = given()
                .multiPart(testFile)
                .when()
                .post("/calculator/uploadLargeFileForInsertionToDatabase")
                .then()
                .extract().response();        
    }

    @Then("An error should occur in the upload")
    public void theScenarioPasses() {
    	Assertions.assertEquals(500, response.statusCode());
    }
}