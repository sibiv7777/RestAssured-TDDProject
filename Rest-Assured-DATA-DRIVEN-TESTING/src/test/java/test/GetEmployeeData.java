package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base.MethodsUsedMultipleTimes;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import net.jodah.failsafe.Timeout;

public class GetEmployeeData extends MethodsUsedMultipleTimes {
	
	@Test(dataProvider="Jps",priority=1)
	public static void empData(String[] dat) throws InterruptedException, IOException, ParseException  {
		
		Thread.sleep(1000);
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		req=RestAssured.given();
		Thread.sleep(1000);
	    response=req.request(Method.GET,"/api/v1/employees");
	    
		String contentOfbody=response.getBody().asPrettyString();
		log.info("contentOfBody");
		System.out.println(contentOfbody);
		
		Headers headers=response.headers();
		System.out.println(headers);
		//Thread.sleep(000);
	  int statusCode=response.getStatusCode();
	  
	  //Thread.sleep(1000);

		AssertJUnit.assertEquals(statusCode, 200);
	if(false) { System.out.println(statusCode);
		System.out.println("statuscode is not 200");}
			else {System.out.println("statusCode is 200");}
		
		System.out.println(response.getContentType());
		//screenShots();
		Thread.sleep(5000);
		AssertJUnit.assertEquals(response.getHeader("Content-type").equalsIgnoreCase(response.contentType()),true);
		System.out.println(response.getHeader("Content-type"));
		System.out.println(response.contentType());
		
		JsonPath path=response.jsonPath();
		int h=path.get("data[0].employee_salary");
		System.out.println(h);
		log.info("employee salary found");
System.out.println(response.getTimeIn(TimeUnit.SECONDS));
//System.out.println(dat[].split(","));
System.out.println(dat[0]);
String g[]=dat[0].split(",");
System.out.println(g[1]);

Thread.sleep(2000);
if(dat[0].equalsIgnoreCase("Gopi,sweeper")) {System.out.println("Yes man");}
	if(dat[0].equalsIgnoreCase("Suresh,Manager")){
	System.out.println("YES");}
	//else {System.out.println("NO");}
Thread.sleep(2000);

		
		}
	
		
	}


