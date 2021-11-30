package service.cafe.order.repository;

import org.springframework.stereotype.Repository;
import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderService implements OrderRepository {

    @Override
    public boolean save(Order order) {
        return false;
    }

    @Override
    public Order delete(Order order) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findByUserId(Long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order updateOrderState(Order order, OrderState orderState) {
        return null;
    }

    @Override
    public Order updateOrderCount(Order order, int count) {
        return null;
    }

}
