package com.ecturing.gp.WebSocket.until.Filter;

import com.ecturing.gp.WebSocket.model.BaseMsg;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface MessageFilter {
    void Filter(BaseMsg msg) throws ExecutionException, InterruptedException;
}
