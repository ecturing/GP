package com.ecturing.Gp.WebSocket.until;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebSocket.model.GroupMsg;

public abstract class MsgFilter {
    public GroupMsg groupMsg;
    public MsgFilter(JSONObject json) {
        this.groupMsg = new GroupMsg(json.getString("message_type"),
                json.getInteger("user_id"),
                json.getInteger("group_id"),
                json.getString("message"),
                json.getBoolean("auto_escape")
        );
    }

    /***
     *
     */
    public abstract void Message_Type_Filter();
    public abstract void User_Id_Filter();
    public abstract void Group_Id_Filter();
    public abstract void Message_Filter();
}
