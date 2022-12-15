package Utility;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ComplexTestDataCreation {
	
	@Test()
	public static void mapData() {
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("Name", "parthiban subburam");
		map.put("Field", "Testing");
		
		List<String> list = new ArrayList<>();
		list.add("Manual"); list.add("UI Automation"); list.add("API Automation");
		
		map.put("Knowledge", list);
		
		Map<String, Object> map1 = new LinkedHashMap<String, Object>();
		map1.put("Manual Experience", "2.3");	
		map1.put("UI Automation", "3");
		map1.put("API AUtomation", "2");
		
		map.put("Experiences", map1);
		System.out.println(map);
	}
	
	@Test(enabled = false)
	public static void jsonObject() {
		
		JSONObject object = new JSONObject();
		object.put("Name", "parthiban subburam");
		object.put("Field", "Testing");
		
		JSONArray array = new JSONArray();
		array.put("Manual");
		array.put("UI Automation");
		array.put("API Automation");
		
		object.put("Knowledge", array);
		JSONObject object1 = new JSONObject();
		object1.put("Manual Experience", "2.3");	
		object1.put("UI Automation", "3");
		object1.put("API AUtomation", "2");
		
		object.put("Experiences", object1);
		System.out.println(object);
		
	}

}
