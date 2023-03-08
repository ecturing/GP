package com.ecturing.gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 基础消息类型，包含群组消息与正常通知消息
 */
@Data
@AllArgsConstructor
public class BaseMsg {
    private String postType;
    private Long user_id;
    private Integer GroupId;
    private String message;
    private Boolean auto_escape;
    private String message_type;

    private Long message_id;
}
