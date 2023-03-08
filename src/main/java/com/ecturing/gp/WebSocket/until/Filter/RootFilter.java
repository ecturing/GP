package com.ecturing.gp.WebSocket.until.Filter;

import com.ecturing.gp.WebSocket.model.BaseMsg;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

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
     * @param baseMsg 消息
     */
    void Post_Type_Filter(BaseMsg baseMsg) throws ExecutionException, InterruptedException;
}
