package com.api.base;

import com.api.models.response.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService_withoutThreadSafe{
	
	//Constant variable 
	private static final String BASE_PATH="/api/users";
	
	
	//For simple GetProfile
	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"/profile");	
	}

	//For PUT request
	public Response updateProfile(String token, ProfileRequest payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH+"/profile");
	}
}
