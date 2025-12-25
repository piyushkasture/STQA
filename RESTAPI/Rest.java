package microservices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Rest {

    @Test
    public void testGet() {
        RestAssured.baseURI = "https://httpbin.org/get";
        Response res = RestAssured.get();
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println("Get Method");
    }

    @Test
    public void testPost() {
        RestAssured.baseURI = "https://httpbin.org/post";
        
        Map<String, Object> dataPost = new HashMap<>();
        dataPost.put("name", "Test");
        
        RequestSpecification request = RestAssured.with().contentType(ContentType.JSON).body(dataPost);
        Response newrespo = request.post();
        
        System.out.println(newrespo.asPrettyString());
        Assert.assertEquals(newrespo.getStatusCode(), 200);
        System.out.println("Post method");
    }
    
    
    @Test
    public void testPut() {
        RestAssured.baseURI = "https://httpbin.org/put";
        
        Map<String, Object> dataPost = new HashMap<>();
        dataPost.put("name", "Piyush");
        
        RequestSpecification request = RestAssured.with().contentType(ContentType.JSON).body(dataPost);
        Response newrespo = request.put();
  
        
        System.out.println(newrespo.asPrettyString());
        Assert.assertEquals(newrespo.getStatusCode(), 200);
        System.out.println("Put method");
    }
    
    @Test
    public void testDelete() {
        RestAssured.baseURI = "https://httpbin.org/delete";
        
        Map<String, Object> dataPost = new HashMap<>();
        dataPost.put("name", "Test");
        
        RequestSpecification request = RestAssured.with().contentType(ContentType.JSON).body(dataPost);
        
        Response newrespo = request.delete();
        
        System.out.println(newrespo.asPrettyString());
        Assert.assertEquals(newrespo.getStatusCode(), 200);
        System.out.println("Delete method");
    }

    @Test
    public void testHead() {
        RestAssured.baseURI = "https://httpbin.org/headers";
        Response res = RestAssured.head();
        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println("Head method");
    }
}
