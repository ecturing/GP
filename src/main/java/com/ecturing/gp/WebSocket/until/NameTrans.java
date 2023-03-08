package com.ecturing.gp.WebSocket.until;

import com.ecturing.gp.Exception.Exception;
import com.ecturing.gp.Exception.InvalidRequest;

import java.util.HashMap;
import java.util.Map;

public class NameTrans {
    private final Map<String,String> commandMap =new HashMap<String,String>();
    public String trans(String command){
        String data= commandMap.get(command);
        if (data==null){
            throw new InvalidRequest(Exception.InvalidCommand.getDescription());
        }
        return data;
    }

    public NameTrans() {
        commandMap.put("天气","Weather");
        commandMap.put("新闻","News");
        commandMap.put("翻译","Translate");
    }
}
