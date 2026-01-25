package com.api.base;

import java.util.HashMap;
import java.util.Map;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService_withoutThreadSafe {
	
	//Constant variable 
	private static final String BASE_PATH="/api/auth/";
	
	// Login Response 
	public Response login(LoginRequest payload)
	{
		return postRequest(payload,BASE_PATH +"login");
	}

	//SignUp
	public Response signUp(SignUpRequest payload)
	{
		return postRequest(payload, BASE_PATH +"signup");
	}
	
	//Forgot Password
	public Response forgotPassword(String  emailAddress)
	{
		//HashMap for KeyValue
		Map<String,String> fpPayload=new HashMap<>();
		fpPayload.put("email",emailAddress);
		
		return postRequest(fpPayload, BASE_PATH +"forgot-password");
	}
	
}
