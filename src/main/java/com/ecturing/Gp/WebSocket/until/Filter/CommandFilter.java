package com.ecturing.Gp.WebSocket.until.Filter;

import com.ecturing.Gp.WebSocket.model.BaseMsg;

import java.util.concurrent.ExecutionException;

public interface CommandFilter {
    void filter(BaseMsg msg,String command) throws ExecutionException, InterruptedException;
}
