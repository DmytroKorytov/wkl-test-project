package com.epam.tests.bdd.handler;

import static io.restassured.RestAssured.given;

import static java.lang.ThreadLocal.withInitial;


import com.epam.wkl.test.dto.response.BaseResponse;
import com.epam.wkl.test.dto.response.OidcDataDto;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public enum  BddContextHandler {
    BDD_CONTEXT;

    private static final String REQUEST = "REQUEST";
    private static final String RESPONSE = "RESPONSE";


    private final ThreadLocal<Map<String, Object>> threadLocal = withInitial(HashMap::new);
    private BaseResponse<OidcDataDto> responseData;

    private Map<String, Object> getContext() {
        return threadLocal.get();
    }

    public RequestSpecification getRequest() {
        RequestSpecification req = get(REQUEST, RequestSpecification.class);
        return (null == req) ? given() : req;
    }

    private <T> T get(String type, Class<T> clazz) {
        return clazz.cast(threadLocal.get().get(type));
    }

    public void setResponse(Response response) {
        set(RESPONSE, response);
    }

    public Response getResponse() {
        return get(RESPONSE, Response.class);
    }

    public void set(String key, Object value) {
        getContext().put(key, value);
    }

    public Object get(String key) {
        return getContext().get(key);
    }

    public void setResponseData(BaseResponse<OidcDataDto> responseData) {
        this.responseData = responseData;
    }

    public BaseResponse<OidcDataDto> getResponseData() {
        return responseData;
    }
}
