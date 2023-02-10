package com.ecturing.Gp.WebSocket.until;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebSocket.model.GroupMsg;

/**
 * JSON转换
 *
 * @author Ecturing
 * @date 2023/02/10
 */
public  class JSONConvert {
    /**
     * JSON转换GroupMsg
     *
     * @param json json
     * @return {@code GroupMsg}
     */
    public static GroupMsg convert(JSONObject json){
        return new GroupMsg(
                json.getString("post_type"),
                json.getInteger("user_id"),
                json.getInteger("group_id"),
                json.getString("message"),
                json.getBoolean("auto_escape"),
                json.getString("message——type")
        );
    }
}
