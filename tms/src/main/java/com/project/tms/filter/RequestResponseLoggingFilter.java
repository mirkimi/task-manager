package com.project.tms.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
@Order(1)
public class RequestResponseLoggingFilter extends OncePerRequestFilter {
    private static final Logger logger = LogManager.getLogger(RequestResponseLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();

        filterChain.doFilter(requestWrapper, responseWrapper);

        long timeTaken = System.currentTimeMillis() - startTime;

        //log request
        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(), request.getCharacterEncoding());
        String queryString = request.getQueryString() == null ? "" : "?" + request.getQueryString();

        logger.info("""
                REQ:
                Method: {}
                Path: {}{}
                Headers: {}
                Body: {}
                """, request.getMethod(), request.getRequestURI(), queryString, getHeaders(request), requestBody);

        //log response
        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(), responseWrapper.getCharacterEncoding());

        logger.info("""
                RES: [{}ms]
                Status: {}
                Headers: {}
                Body: {}
                """, timeTaken, response.getStatus(), getResponseHeaders(responseWrapper), responseBody);

        responseWrapper.copyBodyToResponse();
    }

    private String getHeaders(HttpServletRequest request){
        return Collections.list(request.getHeaderNames()).stream()
                .map(headerName -> headerName + ": " + request.getHeader(headerName))
                .collect(Collectors.joining(","));

    }

    private String getResponseHeaders(HttpServletResponse response){
        return response.getHeaderNames().stream()
                .map(headerName -> headerName + ": " + response.getHeader(headerName))
                .collect(Collectors.joining(","));
    }

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding){
        try{
            return new String(contentAsByteArray, characterEncoding);
        }catch (UnsupportedEncodingException e){
            logger.error("Error getting string value from byte array", e);
            return "";
        }
    }
}