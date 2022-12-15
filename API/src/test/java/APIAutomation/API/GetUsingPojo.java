package APIAutomation.API;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.AllUsers;
import PojoClass.SingleUserClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUsingPojo {

	@Test(enabled = false)
	public void getUsingPojo() throws JsonMappingException, JsonProcessingException {

		String URL = "https://gorest.co.in/public-api/users/1392";
		RequestSpecification request = given();
		Response response = request.when().get(URL);
		String res = response.asString();
		SingleUserClass obj = response.getBody().as(SingleUserClass.class);	
		System.out.println(obj.getData().toString());
	}
	
	@Test(enabled = true)
	public void getAllUsersUsingPojo() throws JsonMappingException, JsonProcessingException {

		String URL = "https://gorest.co.in/public-api/users";
		RequestSpecification request = given();
		Response response = request.when().get(URL);
		AllUsers obj = response.getBody().as(AllUsers.class);	
		System.out.println(obj.getMeta().getPagination().toString());
		System.out.println(obj.getData().get(0).getStatus().toString());
	}
	
}
