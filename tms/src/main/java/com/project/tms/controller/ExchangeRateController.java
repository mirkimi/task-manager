package com.project.tms.controller;

import com.project.tms.constant.MessageConst;
import com.project.tms.enums.StatusEnum;
import com.project.tms.handler.ResponseHandler;
import com.project.tms.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ExchangeRateController extends ResponseHandler {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("api/getExchangeRate")
    public ResponseEntity<Object> getAllExchangeRates(){
        HashMap<String, Object> response = new HashMap<>();
        try{
            response = exchangeRateService.getExchangeRates();
            return ResponseHandler.responseSuccess(StatusEnum.SUCCESS.code, StatusEnum.SUCCESS.status, response);
        }catch(Exception e){
            return ResponseHandler.responseError(StatusEnum.FAILED.code, StatusEnum.FAILED.status, MessageConst.EXCEPTION_ENCOUNTERED);
        }
    }
}