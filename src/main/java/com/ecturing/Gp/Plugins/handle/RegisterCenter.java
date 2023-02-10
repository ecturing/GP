package com.ecturing.Gp.Plugins.handle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 注册中心
 *
 * @author Ec
 * @date 2023/02/08
 */
@Service
public class RegisterCenter {
    @Qualifier("pluginTaskExecutor")
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /*插件服务*/
    public ArrayList<BotPlugins> botPlugins=new ArrayList<>();

    @Value("${plugins}")
    private String pluginNames;

    /**
     * 根据查询到的插件名称初始化对应插件类
     *
     * @param name 名字
     * @return {@code Object}
     * @throws InstantiationException 实例化异常
     * @throws IllegalAccessException 非法访问异常
     * @throws ClassNotFoundException 类没有发现异常
     */
    public static Object getClass(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> cla=Class.forName("com.ecturing.Gp.Plugins.handle.plugins."+name);
        return cla.newInstance();
    }

    /**
     * 注册方法
     *
     * @throws ClassNotFoundException 类没有发现异常
     * @throws InstantiationException 实例化异常
     * @throws IllegalAccessException 非法访问异常
     */
    public  void Register() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] data=pluginNames.split(",");
        Iterator<String> iterator= Arrays.stream(data).iterator();
        while (iterator.hasNext()){
            String name=iterator.next();
            BotPlugins plugins=(BotPlugins)getClass(name);
            botPlugins.add(plugins);
        }
    }

    /***
     * 插件启动
     */
    public void pluginRun(){
        for (BotPlugins plugins : botPlugins) {
            threadPoolTaskExecutor.execute(
                    ()->plugins.Service()
            );
        }
    }
}
