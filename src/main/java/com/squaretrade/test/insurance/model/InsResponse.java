package com.squaretrade.test.insurance.model;

import lombok.Data;

@Data
public class InsResponse<T> {
    private T data;
    private String message;
    public InsResponse() {
        super();
    }

    public InsResponse(T data,String message)
    {
        super();
        this.message=message;
    }
}
