package com.example.webhook.WebHook.service.Handle;

import com.alibaba.fastjson2.JSONObject;

public interface HandleService {
    String run(JSONObject data);
}
