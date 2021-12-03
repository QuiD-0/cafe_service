package service.cafe.order.reposotory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.order.domain.Order;
import service.cafe.order.service.CreateOrderService;

@SpringBootTest
public class OrderSaveRepoTest {

    @Autowired
    public CreateOrderService createOrderService;

    @Test
    @Transactional
    public void saveOrderServiceTest() {
        Order order = new Order(5, 4, 1);
        Order savedOrder = createOrderService.createOrder(order);

        Assertions.assertEquals(order.getUserId(),savedOrder.getUserId());

    }

}
