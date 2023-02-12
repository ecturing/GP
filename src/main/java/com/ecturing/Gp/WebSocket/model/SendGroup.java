package com.ecturing.Gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendGroup {
    Integer group_id;
    String message;

    boolean auto_escape;
}
