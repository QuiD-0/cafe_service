package service.cafe.order.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public Order save(Order order) {
        em.persist(order);
        return order;
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

    @Override
    public List<Order> findDoneOrder() {
        return null;
    }

}
