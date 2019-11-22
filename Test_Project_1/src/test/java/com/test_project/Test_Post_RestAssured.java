package com.test_project;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import com.user.bean.*;


	public class Test_Post_RestAssured  {
		
		@Test
		void registration() throws JsonGenerationException, JsonMappingException, IOException 
		{
	            // Specify base URL//
			RestAssured.baseURI ="https://reqres.in/";
			   // Request object//
			RequestSpecification httpRequest= RestAssured.given();
			  // Response object.//
			//JSONObject reuestparameter=new JSONObject();
			// reuestparameter.put("name", "morpheus");
			// reuestparameter.put("job", "leader");
			ArrayList array=new ArrayList();
			array.add(new UserData("satya","satya@123","Tesrengg","26"));
			array.add(new UserData("amit","amit@123","engg","22"));
			array.add(new UserData("satya2","satya2@123","Tester","24"));
			//Convertion of java Object to Json object//
			
			ObjectMapper mapper=new ObjectMapper();
			String userObject = mapper.writeValueAsString(array);
			System.out.println(userObject);
			httpRequest.header("content-type", "application/json");
			
			 //httpRequest.body(reuestparameter.toJSONString());
			 Response response =httpRequest.request(Method.POST,"/api/users");
			
			 //To get all headers//
			 Headers allheader=response.headers();
			 for(Header headers:allheader)
			 {
				 System.out.println(headers.getName()+"----------->>> "+headers.getValue());
			 }
			 
			// Header validation//
		      //String contentLength= response.header("Content-Length");
		      //System.out.println("Content-Length is: " +contentLength);
		      //Assert.assertEquals(contentLength,"84");
		 //Print response in console window.//
		  	String responsebody=response.getBody().asString();
			System.out.println("Response body is:" +responsebody);
			 // status code validation //
			int statuscode=response.getStatusCode();
			System.out.println(statuscode);
			Assert.assertEquals( statuscode, 201);
			response.jsonPath().get("SuccessCode");
		}
	}
		

			
		


