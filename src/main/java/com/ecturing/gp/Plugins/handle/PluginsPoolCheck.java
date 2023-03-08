package com.ecturing.gp.Plugins.handle;

import com.ecturing.gp.Exception.Exception;
import com.ecturing.gp.Exception.PluginPoolNullException;

import java.util.Map;

/***
 * 插件池为空异常检查
 */

public class PluginsPoolCheck {
    static void check(Map pool){
        if (pool.isEmpty()){
            throw new PluginPoolNullException(Exception.PluginPoolEmpty.getDescription());
        }
    }
}
