package com.ecturing.Gp.Plugins.handle;


import com.ecturing.Gp.WebSocket.service.APIService;
import org.ecturing.Plugins;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Future;

/**
 * 注册中心
 *
 * @author Ec
 * @date 2023/02/08
 */
@Service
public class RegisterCenter implements ApplicationContextAware {
    @Qualifier("pluginTaskExecutor")
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    APIService apiService;
    Map<String, Plugins> PluginsPool=new HashMap<>();


    /***
     * 插件启动
     */
    public  void pluginRun(String name){
        Future<String> data=threadPoolTaskExecutor.submit(
                ()->PluginsPool.get("org.ecturing.plugins"+name).service()
        );
        apiService.SendTo_Bot(String.valueOf(data));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PluginsPool= applicationContext.getBeansOfType(Plugins.class);
    }
}
