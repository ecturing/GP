package com.ecturing.Gp.WebSocket.model;

import lombok.Data;

/***
 * 上报消息
 */
@Data
public class PostData {
    private Integer time;
    private Integer self_id;
    private String post_type;
}
