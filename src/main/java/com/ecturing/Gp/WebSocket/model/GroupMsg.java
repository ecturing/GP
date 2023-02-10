package com.ecturing.Gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupMsg {
    private String PostType;
    private Integer UserId;
    private Integer GroupId;
    private String Msg;
    private Boolean auto_escape;
    private String Message_type;
}
