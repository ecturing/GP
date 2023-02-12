package com.ecturing.Gp.WebSocket.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebSocket.model.SendGroup;
import com.ecturing.Gp.WebSocket.model.SendToBotData;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

@Service
public class APIService {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    /***
     * 发送消息
     * @param data Json字符串
     */
    public void SendTo_Bot(String data){
        SendToBotData send=new SendToBotData("send_group_msg",new SendGroup(706824568,data,false));
        session.getAsyncRemote().sendText(JSON.toJSONString(send));
    }
}
