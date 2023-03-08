package com.ecturing.Gp.Plugins.handle;


import com.ecturing.Gp.Exception.PluginPoolNullException;
import com.ecturing.Gp.WebSocket.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.ecturing.Decorator.PluginData;
import org.ecturing.Plugins;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 注册中心
 *
 * @author Ec
 * @date 2023/02/08
 */
@Service
@Slf4j
public class RegisterCenter implements ApplicationContextAware {
    @Qualifier("pluginTaskExecutor")
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    APIService apiService;
    private Map<String, Plugins> PluginsPool= new HashMap<>();

    /***
     * 获取插件列表
     * @return 插件列表
     */
    public String getPluginsPool() {
        StringBuilder plugin = new StringBuilder("目前启动的插件有：");
        for (String s : PluginsPool.keySet()) {
            plugin.append(s).append(",");
        }
        return plugin.toString();
    }

    /***
     * 带参插件启动
     * @param params 指令参数
     * @param name 指令名（插件名）
     */
    public  void pluginRun(String name,String params) throws ExecutionException, InterruptedException {
        try {
            PluginsPoolCheck.check(PluginsPool);
            PluginData.setData(params);
            Future data=threadPoolTaskExecutor.submit(PluginsPool.get(name));
            apiService.SendTo_Bot(data.get().toString());
        }catch (PluginPoolNullException e){
            log.error(e.getMessage(),"插件池为空");
            apiService.SendTo_Bot("无启用插件");
        }catch (NullPointerException e){
            log.error("插件空指针",e);
            apiService.SendTo_Bot("发生了空指针，请检查插件实现或API是否有异常");
        }
    }

    /***
     * 不带参数差价启动
     * @param name 插件名
     */
    public  void pluginRun(String name)  throws ExecutionException, InterruptedException{
        try {
            PluginsPoolCheck.check(PluginsPool);
            Future data=threadPoolTaskExecutor.submit(PluginsPool.get(name));
            apiService.SendTo_Bot(data.get().toString());
        }catch (PluginPoolNullException e){
            log.error(e.getMessage());
            apiService.SendTo_Bot("无启用插件");
        }catch (NullPointerException e){
            log.error("空指针",e);
            apiService.SendTo_Bot("发生了空指针，请检查插件实现或API是否有异常");
        }
    }

    /***
     * 查找插件并存入map
     * @param applicationContext spring上下文
     * @throws BeansException 找不到类异常
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PluginsPool= applicationContext.getBeansOfType(Plugins.class);
    }
}
