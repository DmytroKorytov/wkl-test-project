package com.epam.wkl.test.utils;

import com.epam.wkl.test.dto.response.BaseResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
JsonUtils .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
public final class JsonUtils {

    private JsonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> BaseResponse<T> fromJson(String jsonData) {
        Type typeOf = new TypeToken<BaseResponse<T>>(){}.getType();
        return new Gson().fromJson(jsonData, typeOf);
    }

    public static <T> String toJson(T object) {
        return new Gson().toJson(object);
    }

}