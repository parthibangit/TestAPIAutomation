package APIAutomation.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.GenRandomData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethod {
	
	public static Map<String, String> map = new HashMap<String, String>();
	String TOKEN = "Bearer 225b80da07ba3f67f173a592b61bf7c441a42897a79fb648da2d1f7fe8152a97";
	
	
	@BeforeClass
	public void setUp() {
		map.put("name", GenRandomData.userName());
		map.put("email", GenRandomData.getEmail());
		map.put("gender", GenRandomData.getGender("male"));
		map.put("status", GenRandomData.getStatus());
		
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public-api/users";
	}
	
	@Test
	public void updateDetails() {
	    RequestSpecification request = given().contentType("application/json").body(map).header("Authorization", TOKEN);
	    Response response = request.when().put("/"+1424);
	    response.then().assertThat().body("data.name", equalTo(map.get("name")));
	    response.prettyPrint();
	}
}
