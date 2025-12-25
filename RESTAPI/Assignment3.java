package microservices;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment3 {

    // GET Method
    @Test
    public void getIndiaDetails() {

        RestAssured.baseURI = "https://restcountries.com/v3.1/name/india";
        Response res = RestAssured.get();

        int statusCode = res.getStatusCode();
        System.out.println("Status Code : " + statusCode);

        Assert.assertEquals(statusCode, 200);
    }

    // HEAD Method
    @Test
    public void headIndia() {

        RestAssured.baseURI = "https://restcountries.com/v3.1/name/india";
        Response res = RestAssured.head();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    // POST Method (public demo)
    @Test
    public void createPost() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        String body = "{ \"title\":\"Student\", \"body\":\"API\", \"userId\":1 }";

        Response res = RestAssured
                .given()
                .header("Content-Type","application/json")
                .body(body)
                .post();

        Assert.assertEquals(res.getStatusCode(), 201);
    }

    // PUT Method
    @Test
    public void updatePost() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
        String body = "{ \"title\":\"Updated Student\" }";

        Response res = RestAssured
                .given()
                .header("Content-Type","application/json")
                .body(body)
                .put();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    // PATCH Method
    @Test
    public void patchPost() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
        String body = "{ \"body\":\"Patch Update\" }";

        Response res = RestAssured
                .given()
                .header("Content-Type","application/json")
                .body(body)
                .patch();

        Assert.assertEquals(res.getStatusCode(), 200);
    }

    // DELETE Method
    @Test
    public void deletePost() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
        Response res = RestAssured.delete();

        Assert.assertEquals(res.getStatusCode(), 200);
    }
}
