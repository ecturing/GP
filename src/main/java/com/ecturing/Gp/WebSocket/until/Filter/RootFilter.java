package com.ecturing.Gp.WebSocket.until.Filter;

import com.ecturing.Gp.WebSocket.model.GroupMsg;
import org.springframework.stereotype.Component;

/**
 * 根滤波器
 *
 * @author Ecturing
 * @date 2023/02/10
 */
@Component
public interface RootFilter {
    /**
     * 上报类型过滤
     *
     * @param groupMsg 消息
     */
    void Post_Type_Filter(GroupMsg groupMsg);
}
