package com.example.webhook.WebHook.service.certificate;

public interface CertificateService {
    /***
     * 证书校验服务
     * @param token 公钥
     * @return 状态
     */
    String Run(String token);
}
