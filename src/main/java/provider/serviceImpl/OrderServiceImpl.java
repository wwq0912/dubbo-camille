package provider.serviceImpl;

import provider.service.OrderService;

public class OrderServiceImpl implements OrderService {
    public String createOrder(String userName) {
        System.out.println("Provider server: creating order for " + userName);
        return "create order successfully";
    }
}
