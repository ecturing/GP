package com.ecturing.Gp.WebSocket.until.Filter;

import com.ecturing.Gp.WebSocket.model.BaseMsg;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface MessageFilter {
    void Filter(BaseMsg msg) throws ExecutionException, InterruptedException;
}
