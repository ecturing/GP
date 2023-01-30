package com.ecturing.Gp.WebHook.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebHook.service.Handle.HandleService;
import com.ecturing.Gp.WebHook.service.certificate.CertificateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "";
    }
}
