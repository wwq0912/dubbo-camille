package consumer;

import framework.Invocation;
import protocol.HttpClient;
import provider.service.OrderService;

public class consumer {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        String result = httpClient.post("localhost", 8080,
                new Invocation(OrderService.class.getName(), "createOrder", new Object[]{"camille"}
                ,new Class[]{String.class}));
        System.out.println("consumer result :"+result);
    }
}
