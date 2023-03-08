package com.ecturing.Gp.Exception;

import lombok.Getter;

public enum Exception {
    PluginPoolEmpty("插件池为空"),
    InvalidCommand("无效指令");
    @Getter
    private final String description;

    Exception(String description) {
        this.description = description;
    }
}
