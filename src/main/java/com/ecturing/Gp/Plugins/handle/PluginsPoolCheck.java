package com.ecturing.Gp.Plugins.handle;

import com.ecturing.Gp.Exception.Exception;
import com.ecturing.Gp.Exception.PluginPoolNullException;

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
