package com.ecturing.gp.WebSocket.until.Filter.impl;

import com.ecturing.gp.WebSocket.model.BaseMsg;
import com.ecturing.gp.WebSocket.until.Filter.MessageFilter;
import com.ecturing.gp.WebSocket.until.Filter.RootFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class RootFilterImpl implements RootFilter {
    @Autowired
    MessageFilter messageFilter;
    /**
     * 上报类型过滤
     *
     * @param baseMsg 消息
     */
    @Override
    public void Post_Type_Filter(BaseMsg baseMsg) throws ExecutionException, InterruptedException {
        //基础事件过滤
        switch (baseMsg.getPostType()){
            case "meta_event":
               log.debug("heart beat");
               break;
            case "message":
                messageFilter.Filter(baseMsg);
                break;
            case "notice":
                log.info("通知消息");
                break;
            default:
                log.debug("invalid value");
        }
    }
}
