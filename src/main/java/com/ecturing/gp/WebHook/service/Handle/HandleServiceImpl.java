package com.ecturing.gp.WebHook.service.Handle;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ecturing.gp.WebHook.model.Author;
import com.ecturing.gp.WebHook.model.Committer;
import com.ecturing.gp.WebHook.model.DataNode;

@org.springframework.stereotype.Service
public class HandleServiceImpl implements HandleService {
    @Override
    public String run(JSONObject data) {
        JSONArray array= data.getJSONArray("commits");
        JSONObject node= array.getJSONObject(0);
        Author author=JSON.to(Author.class,node);
        Committer committer=JSON.to(Committer.class,node);
        DataNode dataNode=new DataNode(node.getString("message"),author,committer,node.getJSONArray("modified"));

        return JSONObject.toJSONString(dataNode);
    }
}
