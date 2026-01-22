package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.ProfileRequest;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileRequest {
	
	@Test(description="To verify UserManagement/Profile PUT (update)")
	
	public void updateProfileTest() {
	//Authentication
	AuthService authService=new AuthService();
	Response response=authService.login(new LoginRequest("sharad2109","wAGONR@16"));
	LoginResponse loginResponse=response.as(LoginResponse.class);
	System.out.println(response.asPrettyString());
	
	System.out.println("-------------End of Auth API-------------------");
	
	UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
	response=userProfileManagementService.getProfile(loginResponse.getToken());
	System.out.println(response.asPrettyString());
	
	UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
	Assert.assertEquals(userProfileResponse.getUsername(),"sharad2109");
	
	System.out.println("-----------------------------------------------");
	
	ProfileRequest profileRequest=new ProfileRequest.Builder()
			.firstName("Shar")
			.lastName("Heg")
			.mobileNumber("3456789")
			.biuld();
	
	response=userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
	Assert.assertEquals(response.getStatusCode(), 200);
	System.out.println(response.asPrettyString());
	}

}
