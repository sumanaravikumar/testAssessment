package hellocucumber.api.multiInsert;

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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import static io.restassured.RestAssured.given;

public class StepDefinitions {
	
	JsonArray requestBody = new JsonArray();
	
    @Given("Insert multi API host name and request body")
    public void anExampleScenario() {
    	RestAssured.baseURI = "http://localhost:8080";
    	    

    	int count  = ThreadLocalRandom.current().nextInt(2, 10);
    	JsonArray array = new JsonArray();
    	
    	for (int i = 1; i <= count-1; i++) {
    		int month = ThreadLocalRandom.current().nextInt(1, 12);
        	int day = ThreadLocalRandom.current().nextInt(1, 28);
        	JsonObject obj = new JsonObject();
			obj.addProperty("birthday", (day<=9?"0"+day:day) + "" + (month<=9?"0"+month:month) + "" + ThreadLocalRandom.current().nextInt(1960, 2010));
			obj.addProperty("gender", "m");
			obj.addProperty("name", Character.toChars(ThreadLocalRandom.current().nextInt(65, 91))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0] + "" + Character.toChars(ThreadLocalRandom.current().nextInt(97, 123))[0]);
			obj.addProperty("natid", "Sum-"+ ThreadLocalRandom.current().nextInt(1, 9));
			obj.addProperty("salary", ThreadLocalRandom.current().nextInt(1000, 100000));
			obj.addProperty("tax", ThreadLocalRandom.current().nextInt(1, 999));
			requestBody.add(obj); 			
		}
    }

    @When("all multi api step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    	System.out.println("Implemented");
    }

    @Then("The records should be inserted")
    public void theScenarioPasses() {
    	Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody.toString())
                .when()
                .post("/calculator/insertMultiple")
                .then()
                .extract().response();

        Assertions.assertEquals(202, response.statusCode());
    }
}