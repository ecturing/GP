package com.example.webhook.plugins.utils;


import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
@Slf4j
public class SendUpClient extends WebSocketClient {
    public SendUpClient(URI serverUri) {
        super(serverUri);
    }

    /**
     * @param serverHandshake
     */
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log.debug("插件客户端启动成功");
    }

    /**
     * @param s
     */
    @Override
    public void onMessage(String s) {

    }

    /**
     * @param i
     * @param s
     * @param b
     */
    @Override
    public void onClose(int i, String s, boolean b) {
        log.info("WS关闭:",b);
    }

    /**
     * @param e
     */
    @Override
    public void onError(Exception e) {
        log.error("插件客户端WS错误：",e);
    }
}
