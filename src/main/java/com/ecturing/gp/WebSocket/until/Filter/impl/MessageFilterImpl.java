package com.ecturing.gp.WebSocket.until.Filter.impl;

import com.ecturing.gp.Exception.InvalidRequest;
import com.ecturing.gp.WebSocket.model.BaseMsg;
import com.ecturing.gp.WebSocket.service.APIService;
import com.ecturing.gp.WebSocket.until.Filter.CommandFilter;
import com.ecturing.gp.WebSocket.until.Filter.MessageFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**
 * 消息内容过滤器
 */
@Component
public class MessageFilterImpl implements MessageFilter {

    @Autowired
    private APIService apiService;

    @Autowired
    private CommandFilter commandFilter;
    @Override
    public void Filter(BaseMsg msg) throws InterruptedException {
        boolean status=msg.getMessage().contains("[CQ:at,qq=2187133634]");
        //调用与监听过滤
        if (status){
            String command= msg.getMessage().replace("[CQ:at,qq=2187133634]","").trim();
            try {
                commandFilter.filter(msg,command);
            }catch (InvalidRequest e){
                apiService.SendTo_Bot("无效请求");
            }catch (ExecutionException e){
                apiService.SendTo_Bot("插件运行出现错误,"+e);
            }
        }else {
            if (msg.getMessage().contains("卧槽")){
                apiService.Delete_Msg(msg.getMessage_id(), msg.getUser_id());
            }
        }
    }
}
