package com.ecturing.gp.WebSocket.model;

import lombok.Getter;

/***
 * 默认群组号
 */
public enum GroupID {
    Test(433790966);
    @Getter
    private final Integer id;

    GroupID(Integer id) {
        this.id = id;
    }
}
