package com.ecturing.gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * API向Bot发送消息
 */
@Data
@AllArgsConstructor
public class SendToBotData {
    String action;
    Object params;
}
