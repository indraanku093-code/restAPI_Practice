package restAPI_ShortHand;

import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestScriptStatic_GET {
	
	@Test
	public void test_GET_01()
	{
		given().when().get("https://reqres.in/api/users?page=2").then().
		statusCode(200).
		body("data.id[0]", equalTo(7)).
		body("data.first_name", hasItems("Michael", "Lindsay"));
		
	
	}

	@Test
	public void test_GET_02()
	{
		given().when().headers("Content-Type", "application/josn").
		get("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		body("ad.company", equalTo("StatusCode Weekly"));
		
	}
	
	@Test
	public void test_GET_03()
	{
		given().when().header("Content-Type", "application/json").
		get("https://reqres.in/api/users/23").
		then().
		statusCode(404);
	}
}
