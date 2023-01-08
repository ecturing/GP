package com.example.webhook.WebSocket.model;

public class GroupMsg {
    private Integer Time;
    private Integer Self_id;
    private Integer PostType;
    private String MsgType;
    private Integer MsgId;
    private Integer UserId;
    private String Msg;
    private String RawMsg;

    public GroupMsg(Integer time, Integer self_id, Integer postType, String msgType, Integer msgId, Integer userId, String msg, String rawMsg) {
        Time = time;
        Self_id = self_id;
        PostType = postType;
        MsgType = msgType;
        MsgId = msgId;
        UserId = userId;
        Msg = msg;
        RawMsg = rawMsg;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public Integer getSelf_id() {
        return Self_id;
    }

    public void setSelf_id(Integer self_id) {
        Self_id = self_id;
    }

    public Integer getPostType() {
        return PostType;
    }

    public void setPostType(Integer postType) {
        PostType = postType;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Integer getMsgId() {
        return MsgId;
    }

    public void setMsgId(Integer msgId) {
        MsgId = msgId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getRawMsg() {
        return RawMsg;
    }

    public void setRawMsg(String rawMsg) {
        RawMsg = rawMsg;
    }
}
