package APIAutomation.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.GenRandomData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CombinationMethods {
	
	static Map<String, String> map = new HashMap<String, String>();
	String TOKEN = "Bearer 225b80da07ba3f67f173a592b61bf7c441a42897a79fb648da2d1f7fe8152a97";
	String URL ="https://gorest.co.in/public-api/users/";
	Response response;
	String userName;
	LinkedHashMap<String, String> hashMap;
	RequestSpecification request;
	
	@BeforeClass
	public void setUp() {
		map.put("name", GenRandomData.userName());
		map.put("email", GenRandomData.getEmail());
		map.put("gender", GenRandomData.getGender("male"));
		map.put("status", GenRandomData.getStatus());
		
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public-api/users";
		
	}
	
	@Test(priority = 0)
	public void postMethod() {
	    request =  given().contentType("application/json").body(map).header("Authorization", TOKEN);
	    response =  request.when().post();                                                                  // Perform a action in API
	    hashMap =  response.then().extract().path("data");
	    response.then()                                                                                     // Verify the previous action outcome
	       .statusCode(200)
	       .assertThat().body("code", equalTo(201));       
	}	
	
	@Test(priority = 1)
	public void getMethod() {
		String id = String.valueOf(hashMap.get("id"));
		request = given();
		response = request.when().get(URL+id);
		response.then().assertThat().body("data.name", equalTo(hashMap.get("name")));
		response.prettyPrint();                                                                            // Print the response as readable way
	}
}
