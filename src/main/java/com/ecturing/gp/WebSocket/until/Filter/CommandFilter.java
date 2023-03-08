package com.ecturing.gp.WebSocket.until.Filter;

import com.ecturing.gp.WebSocket.model.BaseMsg;

import java.util.concurrent.ExecutionException;

public interface CommandFilter {
    void filter(BaseMsg msg,String command) throws ExecutionException, InterruptedException;
}
