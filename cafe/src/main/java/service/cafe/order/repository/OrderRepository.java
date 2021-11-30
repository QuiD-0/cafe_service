package service.cafe.order.repository;

import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    boolean save(Order order);

    Order delete(Order order);

    Optional<Order> findById(Long id);

    List<Order> findByUserId(Long id);

    List<Order> findAll();

    Order updateOrderState(Order order, OrderState orderState);

    Order updateOrderCount(Order order, int count);

}
