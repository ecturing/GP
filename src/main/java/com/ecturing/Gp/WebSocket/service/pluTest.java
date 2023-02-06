package com.ecturing.Gp.WebSocket.service;

import com.ecturing.Gp.Plugins.handle.RegisterCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class pluTest {
    @Autowired
    RegisterCenter registerCenter;

    public void Run() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        registerCenter.Register();
        registerCenter.pluginRun();
    }
}
