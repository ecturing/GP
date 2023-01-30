package com.ecturing.Gp.WebHook.service.certificate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {
    @Value("${WebHook.RSAToken}")
    private String RSAToken;
    @Override
    public String Run(String token) {
        return null;
    }
}
