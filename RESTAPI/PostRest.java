package microservices;

import javax.smartcardio.ResponseAPDU;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PostRest {
	
	
    @Test
    public  void grb() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";

        Map<String, Object> weatherData = new HashMap<>();
        weatherData.put("city", "Pune");
        weatherData.put("temperature", 28);
        weatherData.put("condition", "Sunny");
        weatherData.put("humidity", 60);
        
        
        RequestSpecification request = RestAssured.with().contentType(ContentType.JSON).body(weatherData);
        
        
        Response newrespo = request.post();
        
        System.out.println("status code :" + newrespo.getStatusCode());
        
        Assert.assertEquals(newrespo.getStatusCode(),201,"failed");
        
        
    }
}