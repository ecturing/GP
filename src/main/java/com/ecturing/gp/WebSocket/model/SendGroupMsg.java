package com.ecturing.gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 发送群组消息
 */
@Data
@AllArgsConstructor
public class SendGroupMsg {
    Integer group_id;
    String message;

    boolean auto_escape;
}
