package com.ecturing.Gp.Plugins.handle.plugins;

import com.ecturing.Gp.Plugins.handle.BotPlugins;
import com.ecturing.Gp.Plugins.untils.SendUpClient;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Weather implements BotPlugins {
    private final String URIAddress="https://wis.qq.com/weather/common?source=pc&province=湖北&city=孝感&county=孝南区&weather_type=observe";

    private final String tokenKey="";

    private final String token="";


    @Override
    public void Service() {
        Map<String,String> keymap=new HashMap<>();
        keymap.put(tokenKey,token);
        Map<String,String> data=new HashMap<>();
        data.put("source","pc");
        data.put("province","湖北");
        data.put("city","宜昌");
        data.put("county","宜都");
        data.put("weather_type","observe");
        ResponseEntity<String> WeaData=new SendUpClient(URIAddress, null, HttpMethod.GET,tokenKey,token).SendUp();
        log.info(WeaData.toString());
    }
}
