package com.ecturing.Gp.WebHook.service.Handle;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebHook.model.Author;
import com.ecturing.Gp.WebHook.model.Committer;
import com.ecturing.Gp.WebHook.model.DataNode;

@org.springframework.stereotype.Service
public class HandleServiceImpl implements HandleService {
    @Override
    public String run(JSONObject data) {
        JSONArray array= data.getJSONArray("commits");
        JSONObject node= array.getJSONObject(0);
        Author author=new Author(
                node.getJSONObject("author").getString("name"),
                node.getJSONObject("author").getString("email")
        );
        Committer committer=new Committer(
                node.getJSONObject("committer").getString("name"),
                node.getJSONObject("committer").getString("email")
        );
        DataNode dataNode=new DataNode(node.getString("message"),author,committer,node.getJSONArray("modified"));

        return JSONObject.toJSONString(dataNode);
    }
}
