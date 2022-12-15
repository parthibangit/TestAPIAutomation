package APIAutomation.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	
	String URL = "https://gorest.co.in/public-api/users";

	@Test(enabled = false)
	public void getMethod() {

		RequestSpecification request = given();
		Response response = request.when().get(URL);
		LinkedHashMap<String, String> map = response.then().extract().path("data");   // Use extract() method to get the values from response
		System.out.println(map);
		response.then().log().all();
		response.then().statusCode(200).assertThat().body("code", equalTo(200));
		response.prettyPrint();
        response.statusCode();
	}
		
}
