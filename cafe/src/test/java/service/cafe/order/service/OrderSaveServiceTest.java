package service.cafe.order.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.cafe.order.domain.Order;
import service.cafe.product.service.SaveProductService;
import service.cafe.user.service.UserService;

@SpringBootTest
public class OrderSaveServiceTest {

    @Autowired
    public CreateOrderService createOrderService;

    @Autowired
    public SaveProductService saveProductService;

    @Autowired
    public UserService userService;

    @Test
    public void totalPriceTest() {
        Order order = new Order(5, 4, 10);
        createOrderService.createOrder(order);
    }

}
