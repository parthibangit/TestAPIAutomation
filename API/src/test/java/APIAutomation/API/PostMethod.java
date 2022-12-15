package APIAutomation.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PojoClass.UserClassSerial;
import Utility.GenRandomData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostMethod {
	
	UserClassSerial obj;
	String TOKEN = "Bearer 225b80da07ba3f67f173a592b61bf7c441a42897a79fb648da2d1f7fe8152a97";
	
	@BeforeClass
	public void setUp() {
		obj = new UserClassSerial("Parthi Test", "TestParthi98435@gmail.com", "Male", "Active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public-api/users";		
	}
	
	@Test(priority = 0)
	public void postMethod() {
	     RequestSpecification request = given().contentType("application/json").body(obj).header("Authorization", TOKEN);       // Pre-Condition of our API
	     Response response = request.when().post();                                                                             // Perform a action in API
	     response.then().statusCode(200).assertThat().body("code", equalTo(201));                                               // Verify the previous action outcome
	     response.prettyPrint();     
	}	
}
