package APIAutomation.API;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteMethod {
	
	String TOKEN = "Bearer 225b80da07ba3f67f173a592b61bf7c441a42897a79fb648da2d1f7fe8152a97";
	
	@BeforeClass
	public void setUp() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public-api/users/2577";
	}
	
	@Test
	public void deleteDetails() {
		
		RequestSpecification request = given().header("Authorization",TOKEN);
		Response response = request.when().delete();
		response.then().statusCode(200).assertThat().body("data.message", equalTo("Resource not found"));
		response.prettyPrint();	
	}

}
