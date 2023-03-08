package com.ecturing.Gp.WebSocket.until.Filter.impl;

import com.ecturing.Gp.Plugins.handle.RegisterCenter;
import com.ecturing.Gp.WebSocket.model.BaseMsg;
import com.ecturing.Gp.WebSocket.service.APIService;
import com.ecturing.Gp.WebSocket.until.Filter.CommandFilter;
import com.ecturing.Gp.WebSocket.until.NameTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class CommandFilterImpl implements CommandFilter {
    @Autowired
    private RegisterCenter registerCenter;
    @Autowired
    private APIService service;
    @Override
    public void filter(BaseMsg msg,String command) throws ExecutionException, InterruptedException {
//        插件与指令调用过滤
        if (command.charAt(0)=='/'){
            String flag=command.replace("/","").trim();
            switch (flag){
                case "help":
                    service.SendTo_Bot("命令请使用'/命令'，插件调用如查询天气使用'命令:参数',参数使用','分割，所有指令符号均为英文符号");
                    break;
                case "插件":
                    service.SendTo_Bot(registerCenter.getPluginsPool());
                    break;
                default:
                    service.SendTo_Bot("未定义消息类型");
            }
        }else{
            String[] commandList=command.split(":");
            try {
                registerCenter.pluginRun(new NameTrans().trans(commandList[0]),commandList[1]);
            }catch (ArrayIndexOutOfBoundsException e){
                registerCenter.pluginRun(new NameTrans().trans(command));
            }

        }
    }
}
