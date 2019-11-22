package com.test_project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Response_Body_Validation {
	@Test
	void get() 
	{
            // Specify base URL//
		RestAssured.baseURI ="https://reqres.in/";
		   // Request object//
		RequestSpecification httpRequest= RestAssured.given();
		  // Response object.//
		Response response =httpRequest.request(Method.GET,"/api/users?page=2");
		 //Print response in console window.//
		String responsebody=response.getBody().asString();
		System.out.println("Response body is:" +responsebody);
		Assert.assertEquals(responsebody.contains("page"), true);
		 // status code validation //
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals( statuscode, 200);
		//Status Line validation//
		String statusline =response.getStatusLine();
		System.out.println("Status Line is:"+  statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK" );
		
	}
}
