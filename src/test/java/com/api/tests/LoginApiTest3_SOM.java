package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginApiTest3_SOM {
	
	@Test(description="To verify Login API is working !!!")
	public void loginTest()
	{
		
		LoginRequest loginRequest=new LoginRequest("sharad2109","wAGONR@16");
		AuthService authService=new AuthService();		
		//DeSerializing the JSON object
		Response response=authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		
		//Get from LoginResponse 
		System.out.println(response.asPrettyString());
		System.out.println("Token : " +loginResponse.getToken());
		System.out.println("Email  : " +loginResponse.getEmail());
		System.out.println("ID  : " +loginResponse.getId());
		
		//Assert
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getEmail(),"sharad2109@gmail.com");
		Assert.assertEquals(loginResponse.getId(),3764);
		
	}
	
}
