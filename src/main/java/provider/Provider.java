package provider;

import framework.URL;
import protocol.HttpServer;
import provider.service.OrderService;
import provider.serviceImpl.OrderServiceImpl;
import register.RemoteRegister;

public class Provider {
    public static void main(String[] args) {
        // 远程注册
        RemoteRegister.regist(OrderService.class.getName(), new URL("localhost", 8080));
        // 本地注册
        LocalRegister.regist(OrderService.class.getName(), OrderServiceImpl.class);

        // 启动tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);
    }
}
