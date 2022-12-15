package APIAutomation.API;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.GenRandomData;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FetchJsonHeaderCookiesDetails {
	
	static Map<String, String> map = new HashMap<String, String>();
	String TOKEN = "Bearer 225b80da07ba3f67f173a592b61bf7c441a42897a79fb648da2d1f7fe8152a97";
	RequestSpecification  request;
	Response response;
	
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
	public void fetchJsonDetails() {
		request = RestAssured.given().contentType("Application/json").body(map).header("Authorization", TOKEN);
		response = request.when().post();
		String responseBody = response.body().asString();
		LinkedHashMap<String, String> hashMap = JsonPath.from(responseBody).get("data");
		System.out.println("==========================");
		System.out.println(hashMap);
		System.out.println("==========================");
		response.prettyPrint();
		
	}
	
	@Test(priority = 1)
	public void fetchHeaderDetails() {
		String header = response.getHeader("Content-Type");
		
		System.out.println("==========================");
		System.out.println("Content type is: "+header);
		System.out.println("===========================");
		
		Headers header1 = response.getHeaders();
		System.out.println("Headers is: "+header1);
	}
	
	@Test(priority = 2)
	public void fetchCookiesDetails() {
		String cookie = response.getCookie("__cfduid");
		
		System.out.println("==========================");
		System.out.println("Cookie is: "+cookie);
		System.out.println("===========================");
		
		Map<String, String> map1 = response.getCookies();
		System.out.println("Cookies details: "+map1);
		System.out.println("==========================");
	}

}
