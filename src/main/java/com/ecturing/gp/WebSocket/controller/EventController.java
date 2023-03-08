package com.ecturing.gp.WebSocket.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ecturing.gp.WebSocket.model.BaseMsg;
import com.ecturing.gp.WebSocket.until.Filter.RootFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ExecutionException;

/***
 * 事件控制器
 */

@Component
@Slf4j
@ServerEndpoint("/Ws_Bot_Event")
public class EventController {
    private static RootFilter rootFilter;

    @Autowired
    public  void setRootFilter(RootFilter rootFilter) {
        EventController.rootFilter = rootFilter;
    }

    @OnOpen
    public void Open() {
        log.debug("Event ws connection Start");
    }

    @OnClose
    public void close() {
        log.debug("Event ws connection Start");
    }

    @OnError
    public void error(Session session, Throwable t) {
        log.error("Event ws connection Start Error", t);
    }

    @OnMessage
    public void Message(String Message) throws ExecutionException, InterruptedException {
        JSONObject jsonObject=JSONObject.parseObject(Message);
        BaseMsg msg= JSON.to(BaseMsg.class,jsonObject);
        rootFilter.Post_Type_Filter(msg);
    }
}
