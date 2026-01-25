package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test(description="To verify UserManagement/progile API !!!")
	
	public void getProfileInfoTest() {
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest("sharad2109","wAGONR@16"));
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println("Token : "+loginResponse.getToken());
		
		//Get token from loginResponse
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		
		System.out.println(userProfileResponse.getUsername());
		System.out.println(userProfileResponse.getEmail());
		System.out.println(userProfileResponse.getMobileNumber());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("GetProfileInfo test running on Thread: " + Thread.currentThread().getId());
	}

}
