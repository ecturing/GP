package com.ecturing.Gp.WebSocket.service;

import com.alibaba.fastjson2.JSON;
import com.ecturing.Gp.WebSocket.model.DelGroupMsg;
import com.ecturing.Gp.WebSocket.model.GroupID;
import com.ecturing.Gp.WebSocket.model.SendGroupMsg;
import com.ecturing.Gp.WebSocket.model.SendToBotData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

@Service
@Slf4j
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
        SendToBotData send=new SendToBotData("send_group_msg",new SendGroupMsg(GroupID.Test.getId(), data,false));
        log.debug(data);
        session.getAsyncRemote().sendText(JSON.toJSONString(send));
    }

    /***
     * 撤回消息
     * @param msgId 被撤回消息id
     * @param userid 发送消息人
     */
    public void Delete_Msg(Long msgId,Long userid){
        SendToBotData delete=new SendToBotData("delete_msg",new DelGroupMsg(msgId));
        SendToBotData send=new SendToBotData("send_group_msg",
                new SendGroupMsg(GroupID.Test.getId(),
                "敏感过滤词撤回[CQ:at,qq="+userid+"]",
                false));
        session.getAsyncRemote().sendText(JSON.toJSONString(delete));
        session.getAsyncRemote().sendText(JSON.toJSONString(send));
    }
}
