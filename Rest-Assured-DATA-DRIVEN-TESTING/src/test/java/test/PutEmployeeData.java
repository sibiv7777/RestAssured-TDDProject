package test;



import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.MethodsUsedMultipleTimes;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class PutEmployeeData extends MethodsUsedMultipleTimes{

	@Test(dataProvider="empChange",priority=3)
	public void putEmployeeData(String userName,String jobTitle, String age, String id) throws InterruptedException {
		Thread.sleep(2000);
		//RestAssured.baseURI="http://dummy.restapiexample.com";
	//	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee/1";
			RestAssured.baseURI="http://dummy.restapiexample.com";
		req=RestAssured.given();
		response=req.request(Method.GET,"/api/v1/employee/1");
		System.out.println(response.getBody().asPrettyString());
		Thread.sleep(4000);
		JSONObject obj=new JSONObject();
		obj.put("userName", userName+RandomStringUtils.randomAlphabetic(3));
		obj.put("jobTitle", jobTitle);
		obj.put("age", age);
		obj.put("id", id);
		req.body(obj.toJSONString());
		req.header("Content-type","application/json");
		Thread.sleep(3000);
		response=req.request(Method.PUT,"/api/v1/update/1");
		System.out.println(response.getBody().asPrettyString());
		Thread.sleep(4000);
		int statCode=response.getStatusCode();
		System.out.println(statCode);
		Assert.assertEquals(statCode, 200);
	}

	
}
