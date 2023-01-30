package com.ecturing.Gp.Plugins.handle;


/**
 插件注册中心
 */

import com.ecturing.Gp.Plugins.untils.ThreadPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RegisterCenter {
    @Qualifier("taskExecutor")
    ThreadPoolConfig threadPool;

    /*插件服务*/
    ArrayList<BotPlugins> botPlugins=new ArrayList<>();

    @Value("${plugins}")
    private String[] pluginNames;

    /*根据查询到的插件名称初始化对应插件类*/
    public static Object getClass(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> cla=Class.forName("com.ecturing.Gp.Plugins.handle.plugins"+name);
        return cla.newInstance();
    }
    /*插件注册*/
    public  void Register() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Iterator<String> iterator= Arrays.stream(pluginNames).iterator();
        while (iterator.hasNext()){
            String name=iterator.next();
            BotPlugins plugins=(BotPlugins)getClass(name);
            botPlugins.add(plugins);
        }
    }

    /*插件启动*/
    public void pluginRun(){
        for (BotPlugins plugins : botPlugins) {
            threadPool.taskExecutor().execute(
                    ()->plugins.Service()
            );
        }
    }
}
