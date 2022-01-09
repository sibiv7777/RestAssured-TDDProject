package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.MethodsUsedMultipleTimes;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class DeleteEmployeeData extends MethodsUsedMultipleTimes {

	@Test(priority=4)
	public void deleteEmployee() {

		RestAssured.baseURI = "http://dummy.restapiexample.com";
		req = RestAssured.given();
		response = req.request(Method.DELETE, "/api/v1/delete/1");
		String delete = response.getBody().asPrettyString();
		System.out.println(delete);
		System.out.println(response.getStatusLine());
		System.out.println(response.andReturn().getContentType());
		System.out.println(response.jsonPath().get());
		String message = response.jsonPath().get().toString();
		Assert.assertEquals(message.contains("status=success, data=1, message=Successfully! Record has been deleted"),
				true);

		}

}
