package com.ecturing.Gp.WebSocket.until.Filter;

import com.ecturing.Gp.WebSocket.model.GroupMsg;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RootFilterImpl implements RootFilter {
    @Autowired
    MessageFilter messageFilter;
    /**
     * 上报类型过滤
     *
     * @param groupMsg 消息
     */
    @Override
    public void Post_Type_Filter(GroupMsg groupMsg) {
        switch (groupMsg.getPostType()){
            case "meta_event":
               log.debug("heart beat");
               break;
            case "message":
                messageFilter.Group_Id_Filter(groupMsg.getGroupId());
                messageFilter.Message_Type_Filter(groupMsg.getMessage_type());
                messageFilter.Message_Filter(groupMsg.getMsg());
                messageFilter.User_Id_Filter(groupMsg.getUserId());
                break;
            case "notice":
                break;
            default:
                log.debug("invalid value");
        }
    }
}
