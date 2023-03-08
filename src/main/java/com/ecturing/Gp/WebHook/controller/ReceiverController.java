package com.ecturing.Gp.WebHook.controller;

import com.alibaba.fastjson2.JSONObject;
import com.ecturing.Gp.WebHook.service.Handle.HandleService;
import com.ecturing.Gp.WebHook.service.certificate.CertificateService;
import com.ecturing.Gp.WebSocket.service.APIService;
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

    @Autowired
    APIService apiService;

    @RequestMapping("/Hook")
    public String handler(
            @RequestHeader(value="X-Gitee-Token") String token,
            @RequestBody JSONObject dataForm,
            @RequestHeader(value = "X-Gitee-Event") String X_Gitee_Event){
//        String SendData= handleService.run(dataForm);
//        certificateService.Run(token);
//        log.info(SendData);
//        apiService.SendTo_Bot(SendData);
        switch (X_Gitee_Event){
            case "Push Hook":
                break;
            case "Issue Hook":
                break;
            case "Merge Request Hook":
                break;
        }
        return "";
    }
}
