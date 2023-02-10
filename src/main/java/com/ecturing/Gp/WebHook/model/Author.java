package com.ecturing.Gp.WebHook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

/***
 * 原作者实体类
 */
@Data
@AllArgsConstructor
public class Author {
    public String name;
    public String email;
}
