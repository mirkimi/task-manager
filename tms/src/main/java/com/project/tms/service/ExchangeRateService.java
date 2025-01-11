package com.project.tms.service;

import com.project.tms.constant.MessageConst;
import com.project.tms.constant.ResConst;
import com.project.tms.model.ExchangeRateResponse;
import com.project.tms.rest.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ExchangeRateService extends BaseService{

    @Value("${api.bnm.url.exchange-rate}")
    private String url;

    @Autowired
    private RestApi restApi;

    public HashMap<String, Object> getExchangeRates(){
        HashMap<String, Object> response = new HashMap<>();

        ExchangeRateResponse exchangeRateResponse = restApi.callApi(url, ExchangeRateResponse.class);
        response.put(ResConst.EXCHANGE_RATE_DATA, exchangeRateResponse.getData());
        response.put(ResConst.META, exchangeRateResponse.getMeta());
        response.put(ResConst.MESSAGE, MessageConst.EXCHANGE_RATES_RETRIEVED);

        return response;

    }
}