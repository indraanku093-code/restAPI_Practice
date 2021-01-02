package restAPI_Conventional;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;

import org.hamcrest.Matchers.*;

import java.io.File;
import java.util.*;


public class Testscript_GET 
{

	@Test
	public void test_01()
	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("statuscode "+res.getStatusCode());
		System.out.println("statusline "+res.getStatusLine());
		System.out.println("body "+res.body().asString());
		
	}
	
	@Test
	public void test_02()
	{
		List<String> expfirstname = new ArrayList<String>();
		expfirstname.add("Michael");
		expfirstname.add("Tobias");
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification req = RestAssured.given();
		Response resp = req.get("/users?page=2");
		String value = resp.body().path("data.id[0]").toString();
		Object firstnames = resp.body().path("data.first_name");
		List<String> firstnamesjson = resp.body().jsonPath().getList("data.first_name");
		System.out.println("value "+value);
		System.out.println("firstname = "+firstnames);
		Assert.assertEquals(value, "7", "test passed");
		boolean flag = firstnames.toString().contains("Michael");
		boolean flag1 = firstnames.toString().contains(expfirstname.get(0));
		System.out.println("first name = "+firstnames+" flag= "+flag+" flag1= "+flag1+" "+expfirstname.toString());
		boolean check = firstnamesjson.containsAll(expfirstname);
		System.out.println("json value "+firstnamesjson+" check value = "+check);
	}
	
	@Test
	public void test_03()
	{
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification req = RestAssured.given();
		Response resp = req.get("/users/2");
		String companyName = resp.body().jsonPath().get("ad.company").toString();
		System.out.println("company name ="+companyName);
	}
	
	@Test
	public void test_04()
	{
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification req = RestAssured.given();
		Response resp = req.get("/users/23");
		int value = resp.getStatusCode();
		if(value==404)
			System.out.println("no element is there");
		else
			System.out.println("response are present");
	}
	
	@Test(enabled=false)
	public void test_pract()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number");
		int num = sc.nextInt();
		int a=0;
		String str="";
		for(;num!=0;num=num/10)
		{
			a=a*10+(num%10);
			str = str+String.valueOf(num%10);
		}
		String str1[] = new String[str.length()];
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(i==1)
			{
				String tensplace="";
				switch (ch[i]) {
				case '1':tensplace = tensplace+"ten";
				break;
				case '2':tensplace = tensplace+"twenty";
				break;
				case '3':tensplace = tensplace+"thirty";
				break;
				case '4':tensplace = tensplace+"fourty";
				break;
				case '5':tensplace = tensplace+"fifty";
				break;
				case '6':tensplace = tensplace+"sixty";
				break;
				case '7':tensplace = tensplace+"seventy";
				break;
				case '8':tensplace = tensplace+"eighty";
				break;
				case '9':tensplace = tensplace+"ninety";
				break;
				default:
					tensplace = tensplace+"";
					break;
				}
				str1[i]=tensplace;
			}
			
			else
			{
				str1[i] = value(ch[i], i);
			}
			
		}
		System.out.print("new value = ");
		for (int i = str1.length-1; i >=0; i--) {
			System.out.print(str1[i]+" ");	
		}
		
	}
	
	public static String value(char ch, int i)
	{
		String str="";
		switch (ch) {
		case '1':str = str+" one";
		break;
		case '2':str = str+" two";
		break;
		case '3':str = str+" three";
		break;
		case '4':str = str+" four";
		break;
		case '5':str = str+" five";
		break;
		case '6':str = str+" six";
		break;
		case '7':str = str+" seven";
		break;
		case '8':str = str+" eight";
		break;
		case '9':str = str+" nine";
		break;
		default:
			str = str+"";
			break;
		}
		if(i==0)
			str=str+"";
		else if(i==2)
		{ 
			if(!(str.equals("")))
			str=str+" hundred";
		}
			
		else if(i==3)
		{
			if(!(str.equals("")))
			str=str+" thousand";
			
		}
			
		
		return str;
	}
}
