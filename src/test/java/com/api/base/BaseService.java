package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    private static final String BASE_URL = "http://64.227.160.186:8080";

    // ThreadLocal ensures each thread gets its own RequestSpecification
    private static ThreadLocal<RequestSpecification> requestSpec = ThreadLocal.withInitial(() ->
        given().baseUri(BASE_URL).filter(new LoggingFilter())
    );

    protected void setAuthToken(String token) {
        requestSpec.get().header("Authorization", "Bearer " + token);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return requestSpec.get().contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return requestSpec.get().get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
        return requestSpec.get().contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    // Clear ThreadLocal after test execution to avoid memory leaks
    public static void clear() {
        requestSpec.remove();
    }
}