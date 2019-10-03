package com.epam.wkl.test.dto.response;

/**
BaseResponse .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
public class BaseResponse<T> {

    private String source;
    private T data;

    public String getSource() {
        return source;
    }

    public T getData() {
        return data;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setData(T data) {
        this.data = data;
    }
}