package test;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import base.MethodsUsedMultipleTimes;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class PostEmployeeData extends MethodsUsedMultipleTimes{
	static String[]jsonData;
	@Test(dataProvider="Jps",priority=2)
 public void postEmployeeData(String[] dat) throws InterruptedException {
	 
	 RestAssured.baseURI="http://dummy.restapiexample.com";
	 req=RestAssured.given();
	jsonData= dat[0].split(",");
	System.out.println(jsonData[2]);
		Thread.sleep(4000);
	 JSONObject obj=new JSONObject();
	 obj.put("name",jsonData[0]);
	 obj.put("jobTitle",jsonData[1]);
	 obj.put("age",jsonData[2]);
	 obj.put("id","1");
	 obj.put("name",jsonData[0]);
	 obj.put("jobTitle",jsonData[1]);
	 obj.put("age",jsonData[2]);
	 obj.put("id","2");
	 
	 Thread.sleep(2000);
	 req.body(obj.toJSONString());
	 req.headers("Content-type","application/json");
	 response=req.request(Method.POST,"/api/v1/create");
	String newDataPosted= response.getBody().asPrettyString();
	 System.out.println(newDataPosted);
	int statusCode= response.getStatusCode();
	System.out.println(statusCode);
	 
 }

}
