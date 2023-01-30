package com.ecturing.Gp.WebSocket.model;

public class GroupMsg {
    private String MsgType;
    private Integer UserId;
    private Integer GroupId;
    private String Msg;
    private Boolean auto_escape;

    public GroupMsg(String msgType, Integer userId, Integer groupId, String msg, Boolean auto_escape) {
        MsgType = msgType;
        UserId = userId;
        GroupId = groupId;
        Msg = msg;
        this.auto_escape = auto_escape;
    }

    public String getMsgType() {
        return MsgType;
    }

    public Integer getUserId() {
        return UserId;
    }

    public Integer getGroupId() {
        return GroupId;
    }

    public String getMsg() {
        return Msg;
    }

    public Boolean getAuto_escape() {
        return auto_escape;
    }
}
