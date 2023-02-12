package com.ecturing.Gp.WebSocket.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebSocket.model.GroupMsg;
import com.ecturing.Gp.WebSocket.service.PluginsCenter;
import com.ecturing.Gp.WebSocket.until.Filter.RootFilter;
import com.ecturing.Gp.WebSocket.until.JSONConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/***
 * 事件控制器
 */

@Component
@Slf4j
@ServerEndpoint("/Ws_Bot_Event")
public class EventController {
    private static RootFilter rootFilter;
    private static PluginsCenter pluginsCenter;

    @Autowired
    public void setPluginsCenter(PluginsCenter pluginsCenter) {
        EventController.pluginsCenter = pluginsCenter;
    }

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
    public void Message(String Message) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        JSONObject jsonObject=JSONObject.parseObject(Message);
        GroupMsg msg=JSONConvert.convert(jsonObject);
        rootFilter.Post_Type_Filter(msg);
        pluginsCenter.Run();
    }
}
