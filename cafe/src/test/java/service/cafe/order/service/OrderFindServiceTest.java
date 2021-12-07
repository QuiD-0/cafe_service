package service.cafe.order.service;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderFindServiceTest {

    @InjectMocks
    FindOrderService findOrderService;

    @Mock
    OrderRepository orderRepository;

    @Test
    @DisplayName("ID로 주문 검색하기(있을경우)")
    public void findByIdTestWhenExist() {
        Order order = new Order(1L, 1L, 1);
        given(orderRepository.findById(anyLong())).willReturn(Optional.ofNullable(order));

        Optional<Order> foundOrder = findOrderService.findOneOrderById(1L);

        Assertions.assertEquals(order.getUserId(), foundOrder.get().getUserId());
        Assertions.assertEquals(order.getProductId(), foundOrder.get().getProductId());
    }

    @Test
    @DisplayName("ID로 주문 검색하기(없을경우)")
    public void findByIdTestWhenNotExist() {
        given(orderRepository.findById(anyLong())).willReturn(Optional.empty());

        Optional<Order> foundOrder = findOrderService.findOneOrderById(1L);

        Assertions.assertEquals(foundOrder, Optional.empty());
    }

    @Test
    @DisplayName("모든 주문 검색")
    public void findAllOrdersTest() {
        List<Order> orders = new ArrayList<>() {
            {
                add(new Order(1L, 1L, 1));
                add(new Order(1L, 2L, 2));
            }
        };

        given(orderRepository.findAll()).willReturn(orders);

        List<Order> foundOrders = findOrderService.findAllOrder();

        Assertions.assertEquals(foundOrders, orders);
        Assertions.assertEquals(foundOrders.get(0).getClass(), orders.get(0).getClass());
    }

    @Test
    @DisplayName("사용자 ID로 주문 검색")
    public void findOrdersByUserId() {
        List<Order> orders = new ArrayList<>() {
            {
                add(new Order(1L, 1L, 1));
                add(new Order(1L, 2L, 2));
            }
        };
        given(orderRepository.findByUserId(anyLong())).willReturn(orders);

        List<Order> foundOrders = findOrderService.findOrdersByUserId(12L);

        Assertions.assertEquals(foundOrders, orders);
        Assertions.assertEquals(foundOrders.get(0).getUserId(), orders.get(0).getUserId());
    }

    @Test
    @DisplayName("완료 주문 검색")
    public void findDoneOrders() {
        Order order = new Order(1L, 1L, 1);
        order.setOrderState(OrderState.Done);
        List<Order> orders = new ArrayList<>() {
            {
                add(order);
            }
        };
        given(orderRepository.findDoneOrder()).willReturn(orders);

        List<Order> foundOrders = findOrderService.findDoneOrder();

        Assertions.assertEquals(foundOrders, orders);
        Assertions.assertEquals(foundOrders.get(0).getOrderState(), OrderState.Done);
    }

}
