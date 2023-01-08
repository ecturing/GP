package com.example.webhook.WebSocket.until;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.webhook.WebSocket.model.GroupMsg;

public class MsgFilter {
    public static void MsgDeal(JSONObject json) {
        GroupMsg msg = new GroupMsg(json.getInteger("time"),
                json.getInteger("self_id"),
                json.getInteger("post_type"),
                json.getString("message_type"),
                json.getInteger("message_id"),
                json.getInteger("user_id"),
                json.getString("message"),
                json.getString("raw_message")
        );
        switch (msg.getMsgType())
    }
}
