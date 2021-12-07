package service.cafe.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.cafe.order.domain.Order;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderSaveService {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    CreateOrderService createOrderService;

    @Test
    @DisplayName("주문 생성하기")
    public void createNewOrder() {
        Order order = new Order(1L, 1L, 2);
        Product product = new Product("coffee", "test", 2000, 10);

        given(orderRepository.save(any())).willReturn(order);
        given(productRepository.findById(anyLong())).willReturn(Optional.ofNullable(product));

        Order newOrder = createOrderService.createOrder(order);

        Assertions.assertEquals(order.getUserId(), newOrder.getUserId());
        Assertions.assertEquals(newOrder.getTotalOrderPrice(), order.getCount() * product.getPrice());
    }

}
