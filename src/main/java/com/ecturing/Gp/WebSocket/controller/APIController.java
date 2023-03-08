package com.ecturing.Gp.WebSocket.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebSocket.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/***
 * API控制器
 */
@Component
@Slf4j
@ServerEndpoint("/Ws_Bot_API")
public class APIController {

    private static APIService apiService;

    @Autowired
    public void setApiService(APIService apiService) {
        this.apiService = apiService;
    }

    @OnOpen
    public void OnOpen(Session session){
        log.debug("API ws connection start");
        apiService.setSession(session);
    }
    @OnClose
    public void OnClose(){
        log.info("API ws connection close");
    }
    @OnError
    public void OnError(Throwable throwable){
        log.info("API ws connection ERROR",throwable);
    }
    @OnMessage
    public void OnMessage(String message){
        log.debug(message);
    }

}
