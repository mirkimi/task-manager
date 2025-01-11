package com.project.tms.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestApi {

    @Value("${api.bnm.url.exchange-rate}")
    private String bnmUrl;

    private final RestTemplate restTemplate;

    public RestApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T callApi(String url, Class<T> object){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.BNM.API.v1+json");

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, object).getBody();
    }

}
