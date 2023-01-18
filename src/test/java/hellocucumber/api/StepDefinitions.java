package hellocucumber.api;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static io.restassured.RestAssured.given;

public class StepDefinitions {
	
	String requestBody;
	
    @Given("Insert API host name and request body")
    public void anExampleScenario() {
    	RestAssured.baseURI = "http://localhost:8080";
    	int month = ThreadLocalRandom.current().nextInt(1, 12);
    	int day = ThreadLocalRandom.current().nextInt(1, 28);
    	//DDMMYYYY
    	//
    	requestBody = "{\n" +
                "  \"birthday\": " + (day<=9?"0"+day:day) + "" + (month<=9?"0"+month:month) + "" + ThreadLocalRandom.current().nextInt(1960, 2010) + ",\n" +
                "  \"gender\": \"m\",\n" +
                "  \"name\": \" "+ Character.toChars(ThreadLocalRandom.current().nextInt(65, 91))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "\", \n"+
                "  \"natid\": \"Sum-"+ ThreadLocalRandom.current().nextInt(1, 9) + "\", \n"+
                "  \"salary\": \""+ ThreadLocalRandom.current().nextInt(1000, 100000)  + "\", \n"+
                "  \"tax\": \""+ ThreadLocalRandom.current().nextInt(1, 999) + "\" \n}";
    }

    @When("all api step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    	System.out.println("Implemented");
    }

    @Then("The record should be inserted")
    public void theScenarioPasses() {
    	Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/calculator/insert")
                .then()
                .extract().response();

        Assertions.assertEquals(202, response.statusCode());
    }
}