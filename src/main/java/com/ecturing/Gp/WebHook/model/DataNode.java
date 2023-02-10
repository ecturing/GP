package com.ecturing.Gp.WebHook.model;

import com.alibaba.fastjson2.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 数据节点
 */
@Data
@AllArgsConstructor
public class DataNode {
    public String message;
    public Author author;
    public Committer committer;
    public JSONArray modified;
}
