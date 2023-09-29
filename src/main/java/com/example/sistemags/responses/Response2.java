package com.example.sistemags.responses;

import java.util.List;

public class Response2 {

    private String message;
    private int code;

    List data;

    public Response2(String message, int code, List data){
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public List getData() {
        return data;
    }
}
