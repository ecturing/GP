package com.ecturing.gp.WebHook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * 提交者实体类
 */
@Data
@AllArgsConstructor
public class Committer {
    public String name;
    public String email;
}
