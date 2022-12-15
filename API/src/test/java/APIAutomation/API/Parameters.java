package APIAutomation.API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Parameters {
	
	String URL = "https://gorest.co.in/public-api/users";
	
	@Test(description = "This is path parameter", enabled = true)
	public void pathParameter() {
		RequestSpecification request = given().pathParam("code", "200");
		Response response = request.when().get(URL+"/{code}");       // URL be like https://gorest.co.in/public-api/users/200
		response.then().statusCode(200).assertThat().body("code", equalTo(200));
		response.prettyPrint();
	}
	
	@Test(description = "This is query parameter", enabled = true)
	public void queryParameter() {
		RequestSpecification request = given().queryParam("name", "vetri").queryParam("status", "Active");
		Response response = request.when().get(URL);     // URL be like https://gorest.co.in/public-api/users?name=vetri&status=Active
		response.then().statusCode(200).assertThat().body("code", equalTo(200));
		response.prettyPrint();
	}

}
