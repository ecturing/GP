package com.example.webhook.WebSocket.controller;

import com.alibaba.fastjson2.JSON;
import com.example.webhook.WebSocket.until.MsgFilter;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Slf4j
@ServerEndpoint("/Bot")
public class MainController {
    @OnOpen
    public void Open(){
        log.info("WebSocket Start");
    }

    @OnClose
    public void close(){
        log.info("WebSocket Close");
    }

    @OnError
    public void error(Session session,Throwable t){
        log.error("WebSocket Error");
    }

    @OnMessage
    public void Message(String Message) {
        MsgFilter.MsgDeal(JSON.parseObject(Message));
    }
}
