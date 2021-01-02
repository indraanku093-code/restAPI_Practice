package restAPI_ShortHand;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import restAPI_Utilities.EndPoints;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScriptStatic_GET implements EndPoints{
	
	@BeforeMethod
	public void beforeTestScriptStatic_GET() {
		baseURI = "https://reqres.in";
		
		
	}
	
	@Test
	public void test_GET_01()
	{
		given().contentType(ContentType.JSON).log().all().when().get(NORMALGET).andReturn().
		then().
		statusCode(200).
		body("data.id[0]", equalTo(7)).
		body("data.first_name", hasItems("Michael", "Lindsay")).log().all();
	}

	@Test
	public void test_GET_02()
	{
		given().contentType(ContentType.JSON).log().all().pathParam("id", "2").when().headers("Content-Type", "application/josn").
		get(GETID).andReturn().
		then().
		statusCode(200).log().all();
		
		
	}
	
	@Test
	public void test_GET_03()
	{
		given().contentType(ContentType.JSON).log().all().pathParam("id", "23").when().header("Content-Type", "application/json").
		get(GETID).andReturn().
		then().
		statusCode(404).log().all();
	}
}
