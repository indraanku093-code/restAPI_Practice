package restAPI_ShortHand;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import restAPI_Utilities.EndPoints;
import restAPI_Utilities.POST_PojoPage;

public class TestScriptPojoClass_POST implements EndPoints{
	
	@BeforeMethod
	public void beforeTestScriptPojoClass_POST() {
		baseURI = "https://reqres.in";
	}
	
	@Test
	public void test_POST_01()
	{

		Map< String, Object> str = new HashMap<String, Object>();
		str.put("name", "John");
		str.put("job", "leader");
		POST_PojoPage pclass = new POST_PojoPage();
		pclass.setName(String.valueOf(str.get("name")));
		pclass.setJob(String.valueOf(str.get("job")));
		
		
		given().contentType(ContentType.JSON).log().all().
		when().
		body(pclass).post(POSTURI).then().statusCode(201).
		log().all();
		
		
	}
}
