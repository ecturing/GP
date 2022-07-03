package com.example.webhook.WebHook.model;

/***
 * 提交者实体类
 */
public class Committer {
    public String name;
    public String email;

    public String getName() {
        return name;
    }

    public Committer(String name, String email) {
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
