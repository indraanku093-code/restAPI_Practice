package restAPI_ShortHand;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import restAPI_Utilities.EndPoints;

public class TestScriptStatic_POST implements EndPoints
{
	@BeforeMethod
	public void beforeTestScriptStatic_POST() {
		baseURI = "https://reqres.in";
	}
	
	@Test
	public void test_POST_01()
	{

		Map< String, Object> str = new HashMap<String, Object>();
		str.put("name", "tom");
		str.put("job", "leader");
		JSONObject json = new JSONObject(str);
		
		given().contentType(ContentType.JSON).log().all().
		when().
		body(json).post(POSTURI).then().statusCode(201).
		log().all();
		
		
	}
}
