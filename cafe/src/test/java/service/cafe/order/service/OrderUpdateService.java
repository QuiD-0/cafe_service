package service.cafe.order.service;

import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.domain.Product;
import service.cafe.product.service.FindProductService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderUpdateService {

    @Mock
    OrderRepository orderRepository;

    @Mock
    FindProductService findProductService;

    @InjectMocks
    UpdateOrderService updateOrderService;

    @Test
    @DisplayName("주문 취소")
    public void cancelOrder() {
        Order order = new Order(1l, 1l, 1);
        order.setOrderState(OrderState.Canceled);
        given(orderRepository.delete(any())).willReturn(order);

        Order updatedOrder = updateOrderService.CancelOrder(new Order());

        Assertions.assertEquals(updatedOrder, order);
        Assertions.assertEquals(updatedOrder.getOrderState(), OrderState.Canceled);
    }

    @Test
    @DisplayName("주문상태변경")
    public void updateOrderStateTest() {
        Order order = new Order(1L, 1L, 1);
        order.setOrderState(OrderState.Making);
        given(orderRepository.updateOrderState(any(), eq(OrderState.Making))).willReturn(order);

        Order updatedOrder = updateOrderService.changeOrderState(new Order(), OrderState.Making);

        Assertions.assertEquals(order, updatedOrder);
        Assertions.assertEquals(updatedOrder.getOrderState(), OrderState.Making);
    }

    @Test
    @DisplayName("주문 개수 변경")
    public void updateOrderCountTest() throws NotFoundException {
        Order order = new Order(1L, 1L, 1);
        Product product = new Product("Coffee", "Test", 2000, 10);
        order.setTotalOrderPrice(product.getPrice() * order.getItemCount());
        given(findProductService.findOne(anyLong())).willReturn(product);
        given(orderRepository.updateOrderCount(any(), anyInt(), anyInt())).willReturn(order);

        Order updatedOrder = updateOrderService.changeOrderProductCount(order, 123);

        Assertions.assertEquals(updatedOrder, order);
    }

}
