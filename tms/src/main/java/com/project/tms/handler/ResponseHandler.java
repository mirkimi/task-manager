package com.project.tms.handler;

import com.project.tms.constant.ResConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseSuccess(String code, String status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put(ResConst.CODE, code);
        response.put(ResConst.STATUS, status);
        response.put(ResConst.DATA, data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Object> responseError(String code, String status, String errorCode) {
        Map<String, Object> response = new HashMap<>();
        response.put(ResConst.CODE, code);
        response.put(ResConst.STATUS, status);
        response.put(ResConst.ERROR_CODE, errorCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
