package com.ecturing.Gp.WebSocket.until.Filter;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface MessageFilter {
    /**
     * 消息类型过滤
     */
    void Message_Type_Filter(String MessageType);

    /**
     * 用户id过滤器
     */
     void User_Id_Filter(Integer UserId);

    /**
     * 群组id过滤器
     */
     void Group_Id_Filter(Integer GroupId);

    /**
     * 消息过滤器
     */
     void Message_Filter(String Message) throws ExecutionException, InterruptedException;
}
