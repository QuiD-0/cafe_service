package service.cafe.order.service;

import org.springframework.stereotype.Service;
import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;
import service.cafe.order.repository.OrderRepository;

@Service
public class UpdateOrderService {

    private final OrderRepository orderRepository;

    public UpdateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    Order changeOrderState(Order order, OrderState orderState) {
        return orderRepository.updateOrderState(order, orderState);
    }

    Order changeOrderProductCount(Order order, int count) {
        return orderRepository.updateOrderCount(order, count);
    }

    Order CancelOrder(Order order) {
        return orderRepository.delete(order);
    }

}
