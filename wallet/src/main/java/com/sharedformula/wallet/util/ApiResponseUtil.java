package com.sharedformula.wallet.util;

import com.sharedformula.wallet.apiresponse.ApiDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ApiResponseUtil {

    public static  <T> ResponseEntity<ApiDataResponse<T>> response(HttpStatus status, T data, String message ){
        return ApiResponseUtil.getResponse(status,data,message);
    }

    private static  <T> ResponseEntity<ApiDataResponse<T>> getResponse(HttpStatus status, T data, String message ){
        ApiDataResponse<T> ar = new ApiDataResponse<>(HttpStatus.OK);
        ar.setData(data);
        ar.setTimestamp(LocalDateTime.now());
        ar.setMessage(message);
        return new ResponseEntity<>(ar,status);
    }

    public static ResponseEntity<ApiDataResponse> errorResponse(HttpStatus status, String errMsg){
        ApiDataResponse ar = new ApiDataResponse<>(status);
        ar.setMessage(errMsg);
        return new ResponseEntity<>(ar,status);
    }
}
