package com.example.webhook.WebHook.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.webhook.WebHook.service.Handle.HandleService;
import com.example.webhook.WebHook.service.certificate.CertificateService;
import com.example.webhook.plugins.utils.SendUpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@Slf4j
public class ReceiverController {
    @Autowired
    HandleService handleService;

    @Autowired
    CertificateService certificateService;

    @RequestMapping("/Hook")
    public String handler(
            @RequestHeader(value="X-Gitee-Token") String token,
            @RequestBody JSONObject dataForm){
        String SendData= handleService.run(dataForm);
        certificateService.Run(token);
        log.info(SendData);
        try {
            new SendUpClient(new URI("localhost:8080/Api")).send(SendData);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
