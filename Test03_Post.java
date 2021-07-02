import static io.restassured.RestAssured.get;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

public class Test03_Post {

	@Test
	public void test01_post() {

		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "leader");
		//System.out.println(request);
		System.out.println(request.toJSONString());		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).

		body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();		
	}

	@Test
	public void test02_put() {

		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		//System.out.println(request);
		System.out.println(request.toJSONString());	
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();		
	}

	@Test
	public void test03_patch() {

		JSONObject request=new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
		//System.out.println(request);
		System.out.println(request.toJSONString());	
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();			
	}


	@Test
	public void test04_delete() {

		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();			
	}

	@Test
	public void test05_post() {

		JSONObject request=new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");
		//System.out.println(request);
		System.out.println(request.toJSONString());		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).

		body(request.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();		
		
	}
	
	@Test
	public void test06_post() {

		JSONObject request=new JSONObject();
		request.put("email", "sydney@fife");
		System.out.println(request.toJSONString());		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).

		body(request.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400).log().all();		
		
	}
	
	@Test
	public void test07_post() {

		JSONObject request=new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password","cityslicka");
		System.out.println(request.toJSONString());		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).

		body(request.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();		
		
	}
	
	@Test
	public void test08_post() {

		JSONObject request=new JSONObject();
		request.put("email", "peter@klaven");
		System.out.println(request.toJSONString());		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log().all();		
		
	}
	
	@Test
	public void Test_09_get() {
		Response response=get("https://reqres.in/api/users?delay=3");
		System.out.println("Test Case_06");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	

}
