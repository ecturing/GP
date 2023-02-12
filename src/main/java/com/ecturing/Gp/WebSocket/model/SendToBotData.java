package com.ecturing.Gp.WebSocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class SendToBotData {
    String action;
    SendGroup params;
}
