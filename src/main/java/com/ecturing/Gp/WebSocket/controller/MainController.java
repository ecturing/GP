package com.ecturing.Gp.WebSocket.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebSocket.model.GroupMsg;
import com.ecturing.Gp.WebSocket.service.PluginsCenter;
import com.ecturing.Gp.WebSocket.until.Filter.RootFilter;
import com.ecturing.Gp.WebSocket.until.JSONConvert;
import com.ecturing.Gp.WebSocket.until.Filter.MessageFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Component
@Slf4j
@ServerEndpoint("/ws_Bot")
public class MainController {
    private static RootFilter rootFilter;
    private static PluginsCenter pluginsCenter;

    private Session session;

    @Autowired
    public void setPluginsCenter(PluginsCenter pluginsCenter) {
        MainController.pluginsCenter = pluginsCenter;
    }

    @Autowired
    public  void setRootFilter(RootFilter rootFilter) {
        MainController.rootFilter = rootFilter;
    }

    @OnOpen
    public void Open() {
        log.info("WebSocket Start");
    }

    @OnClose
    public void close() {
        log.info("WebSocket Close");
    }

    @OnError
    public void error(Session session, Throwable t) {
        log.error("WebSocket Error", t);
    }

    @OnMessage
    public void Message(String Message) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        JSONObject jsonObject=JSONObject.parseObject(Message);
        GroupMsg msg=JSONConvert.convert(jsonObject);
        rootFilter.Post_Type_Filter(msg);
        pluginsCenter.Run();
    }
}
