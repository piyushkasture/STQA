package microservices;

import java.util.Currency;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GetRest {

	@Test
    public void testGetAllCountries()  {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://restcountries.com/v3.1/";

		Response response = RestAssured.get("/name/all");



		System.out.println("staus: " + response.statusCode());
//		System.out.println("time: " + response.getTime());
		System.out.println("type: " + response.getContentType());
		System.out.println("headers: " + response.headers());
		System.out.println("body: " + response.body().asString());
		System.out.println("body: " + response.getStatusLine());



        System.out.println(" Response: " + response.asString());
        
        JsonPath jsonPath = response.jsonPath();

        List<Map<String, Object>> countries = 
        		jsonPath.getList("currencies");
        

        for (Map<String, Object> currency : countries) {
            if(currency !=null) {
            	System.out.println(currency.keySet());
            }
        
     
        }
//        if(response.statusCode()==200) {
//        	
//        	System.out.println("test pass");
//        }
//        else {
//        	System.out.println("fail");
//        }

//        Assert.assertEquals(response.statusCode(), 200, "passeDSDd");
		Assert.assertTrue(response.getBody().asString().contains("name"),"ETRRRRR");


		
	}

}
