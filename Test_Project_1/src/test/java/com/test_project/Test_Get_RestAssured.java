package com.test_project;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import com.user.bean.JsonToJava;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

	public class Test_Get_RestAssured {
		
		@Test
		void get() throws JsonParseException, JsonMappingException, IOException 
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
			
			//Convertion of Json to Java Object//
			ObjectMapper mapper=new ObjectMapper();
			JsonToJava javaObject = mapper.readValue( responsebody,JsonToJava.class);
			System.out.println(javaObject.getTotal());
			System.out.println(javaObject.getPer_page());
			
			System.out.println(javaObject.getTotal_pages());
		
			System.out.println(javaObject.getData()[0].getId());
			
			System.out.println(javaObject.getData()[0].getFirst_name());
			System.out.println(javaObject.getData()[1].getId());
			System.out.println(javaObject.getData()[1].getLast_name());
			Assert.assertEquals(javaObject.getData()[2].getEmail(),"tobias.funke@reqres.in");
			
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



