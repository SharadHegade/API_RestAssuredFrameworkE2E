package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	
	@Test(description="To verify Authentication/Forgot Password API is working !!!")
	public void verfiyForgotPassword()
	{
		AuthService authService=new AuthService();
		Response response=authService.forgotPassword("sharad2109@gmail.com");
		System.out.println(response.asPrettyString());
	}
	
}
