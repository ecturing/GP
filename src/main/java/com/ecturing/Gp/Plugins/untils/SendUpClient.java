package com.ecturing.Gp.Plugins.untils;

/***
 * 插件外部请求客户端
 */

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class SendUpClient {
    private String path;//请求地址
    private JSONObject data;//请求体
    private HttpMethod method;
    private String tokenKey;
    private String token;

    public SendUpClient(String path, JSONObject data, HttpMethod method, String tokenKey, String token) {
        this.path = path;
        this.data = data;
        this.method = method;
        this.tokenKey = tokenKey;
        this.token = token;
    }

    public ResponseEntity<String> SendUp(){
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set(tokenKey,token);
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(data, headers);
        return client.exchange(path, method, requestEntity, String.class);
    }
}
