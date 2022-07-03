package com.example.webhook.WebHook.model;

import com.alibaba.fastjson2.JSONArray;

import java.util.Arrays;

/***
 * 数据节点
 */
public class DataNode {
    public DataNode(String message, Author author, Committer committer,JSONArray modified) {
        this.message = message;
        this.author = author;
        this.committer = committer;
        this.modified = modified;
    }

    public String message;
    public Author author;
    public Committer committer;
    public JSONArray modified;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public JSONArray getModified() {
        return modified;
    }

    public void setModified(JSONArray modified) {
        this.modified = modified;
    }
}
