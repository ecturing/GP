package com.ecturing.Gp.Plugins.handle;

import com.ecturing.Gp.Exception.PluginException;
import com.ecturing.Gp.Exception.PluginPoolNullException;

import java.util.Map;

public class PluginsPoolCheck {
    static void check(Map pool){
        if (pool.isEmpty()){
            throw new PluginPoolNullException(PluginException.PluginPoolEmpty.getDescription());
        }
    }
}
