package com.ipseweb.traffic.exception;

import com.ipseweb.traffic.dto.error.Response;
import org.springframework.http.ResponseEntity;

public class ResponseEntityFactory<T> {
    public static <T>ResponseEntity<Response<T>> success(T data) {
        Response<T> response = Response.success(data);
        return new ResponseEntity<>(response, response.getStatus());
    }

}
