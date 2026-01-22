package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description="To verify Authontication/Account Creation API is working !!!")
		
	public void createAccountTest(){
		
		//Calling Builder class - static method
		SignUpRequest signUpRequest=new SignUpRequest.Builder()
		.userName("Amith5")
		.email("amith13@gmail.com")
		.firstName("Amith3")
		.password("amith67")
		.lastName("Hegde3")
		.mobileNumber("1234567890")
		.build();
		
		//AuthService object
		AuthService authService=new AuthService();
		Response response=authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		//Assert
		Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
			
	}
	
}
