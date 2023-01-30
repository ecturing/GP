package com.ecturing.Gp.Plugins.handle.plugins;

import com.ecturing.Gp.Plugins.handle.BotPlugins;
import com.ecturing.Gp.Plugins.untils.SendUpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class Weather implements BotPlugins {
    @Value("${Weather.WeatherAPI}")
    private String URIAddress;

    @Value("${Weather.TokenKey}")
    private String tokenKey;

    @Value("${Weather.APIToken}")
    private String token;

    @Override
    public void Service() {
        Map<String,String> keymap=new HashMap<>();
        keymap.put(tokenKey,token);
        new SendUpClient(URIAddress, null, HttpMethod.GET,tokenKey,token);
    }
}
