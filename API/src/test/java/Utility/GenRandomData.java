package Utility;

import org.apache.commons.lang3.RandomStringUtils;

public class GenRandomData {

	
   public static String userName() {
	   String name = RandomStringUtils.randomAlphabetic(5);
	   return ("FirstName "+name);	   
   }
	

   public static String getStatus() { 
	   return "Active";	   
   }
   
   public static String getEmail() {
	   String amount = RandomStringUtils.randomAlphabetic(2);
	   return ("test."+amount+"@gmail.com");	   
   }
   
   public static String getGender(String gender) {   
	   if(gender.equalsIgnoreCase("male")) {
		   gender = "Male";
	   }
	   else {
		   gender = "Female";
	   }
	   return gender;   
   }
   
   public static void numeric() {
	   String num = RandomStringUtils.randomNumeric(5);
   }
}
