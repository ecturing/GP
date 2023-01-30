package com.ecturing.Gp.WebHook.model;

import org.springframework.context.annotation.Bean;

/***
 * 原作者实体类
 */
public class Author {
    public String name;
    public String email;

    public String getName() {
        return name;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
