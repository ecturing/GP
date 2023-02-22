package com.ecturing.Gp.Exception;

import lombok.Getter;

public enum PluginException {
    PluginPoolEmpty("插件池为空");
    @Getter
    private final String description;

    PluginException(String description) {
        this.description = description;
    }
}
