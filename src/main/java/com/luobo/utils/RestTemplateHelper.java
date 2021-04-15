package com.luobo.utils;

import org.springframework.lang.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;

/**
 * RestTemplateHelper class
 * Http访问帮助类
 * @author chenlingyu
 * @date 2020/6/6 14:40
 */
public class RestTemplateHelper {

    private static RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return restTemplate;
    }

    public static <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request, Class<T> responseType) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.postForEntity(url, request, responseType);
    }

    public static <T> ResponseEntity<String> postForString(String url, @Nullable Object request) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.postForEntity(url, request, String.class);
    }

    public static <T> ResponseEntity<String> getForString(String url) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForEntity(url, String.class);
    }

    public static <T> ResponseEntity<T> getForEntity(String url,Class<T> responseType) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForEntity(url, responseType);
    }

}
