import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test02_Get {

	@Test
	void Test_01() {

		Response response =get("https://reqres.in/api/users?page=2");
		System.out.println("Test Case_01");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	void Test_02()
	{

		Response response=get("https://reqres.in/api/users/2");
		System.out.println("Test Case_02");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);


	}

	@Test
	void Test_03() {
		Response response=get("https://reqres.in/api/users/23");
		System.out.println("Test Case_03");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
	}
	
	

	@Test
	void Test_04() {
		Response response=get("https://reqres.in/api/unknown");
		System.out.println("Test Case_04");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	void Test_05() {
		Response response=get("https://reqres.in/api/unknown/2");
		System.out.println("Test Case_05");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	void Test_06() {
		Response response=get("https://reqres.in/api/unknown/23");
		System.out.println("Test Case_06");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 404);
	}
	
	
}
