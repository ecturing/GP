package com.ecturing.Gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 发送群组消息
 */
@Data
@AllArgsConstructor
public class SendGroup {
    Integer group_id;
    String message;

    boolean auto_escape;
}
