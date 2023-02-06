package com.ecturing.Gp.WebSocket.controller;

import com.ecturing.Gp.WebSocket.service.pluTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Component
@Slf4j
@ServerEndpoint("/ws_Bot")
public class MainController {
    @Autowired
    private pluTest pluTest;

    private Session session;
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
        log.error("WebSocket Error",t);
    }

    @OnMessage
    public void Message(String Message) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        MsgFilter.MsgDeal(JSON.parseObject(Message));
        log.info(Message);

        pluTest.Run();
    }
}
