package APIAutomation.API;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthTypes {
	
	@BeforeClass
	public void setUp() {
		
		RestAssured.baseURI = "https://restapi.demoqa.com/authentication/CheckForAuthentication";
		RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
	}
	
	@Test(priority = 1, enabled = false)
	public void basicAuth() {
		
		RequestSpecification request = given().auth().basic("", "");
		Response response = request.when().get("");
		response.then().statusCode(200);
	}
	
	@Test(priority = 0, enabled = false)
	public void preemptiveAuth() {
		
		RequestSpecification request = given().auth().preemptive().basic("ToolsQA", "TestPassword");
		Response response = request.when().get();
		response.then().statusCode(200);
		response.prettyPrint();
	}
	
	@Test(priority = 2, enabled = true)
	public void oAuth() {
		
		RequestSpecification request = given().auth().oauth2("Token");
		Response response = request.when().get();
		response.then().statusCode(200);
		response.prettyPrint();
	}

}
