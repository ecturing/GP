package com.ecturing.Gp.WebSocket.until.Filter;

import com.ecturing.Gp.Plugins.handle.RegisterCenter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageFilterImpl implements MessageFilter {
    @Autowired
    RegisterCenter registerCenter;


    /**
     * 消息类型过滤
     *
     * @param MessageType
     */
    @Override
    public void Message_Type_Filter(String MessageType) {

    }

    /**
     * 用户id过滤器
     *
     * @param UserId
     */
    @Override
    public void User_Id_Filter(Integer UserId) {

    }

    /**
     * 群组id过滤器
     *
     * @param GroupId
     */
    @Override
    public void Group_Id_Filter(Integer GroupId) {

    }

    /**
     * 消息过滤器
     *
     * @param Message
     */
    @Override
    public void Message_Filter(String Message) {
        log.info(Message);
        if (Message.contains("/天气")) {
            registerCenter.pluginRun("Weather");
        }
    }
}
