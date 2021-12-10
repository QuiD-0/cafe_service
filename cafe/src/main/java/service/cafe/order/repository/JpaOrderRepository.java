package service.cafe.order.repository;

import org.springframework.stereotype.Repository;
import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Order save(Order order) {
        em.persist(order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(em.find(Order.class, id));
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return em.createQuery("select m from Order m where m.userId = :userId ", Order.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("select m from Order m", Order.class).getResultList();
    }

    @Override
    public List<Order> findDoneOrder() {
        return em.createQuery("select m from Order m where m.orderState =: orderState ", Order.class).setParameter("orderState", OrderState.Done).getResultList();
    }

    @Override
    public Order delete(Order order) {
        //주문 삭제 X, 주문 상태 변경
        Order cancelOrder = em.find(Order.class, order.getId());
        cancelOrder.setCanceled(true);
        LocalDateTime date = LocalDateTime.now();
        cancelOrder.setOrderTime(date);
        cancelOrder.setOrderState(OrderState.Canceled);
        return cancelOrder;
    }

    @Override
    public Boolean hardDelete(Order order){
        em.find(Order.class,order.getId());
        em.remove(order);
        return true;
    }

    @Override
    public Order updateOrderState(Order order, OrderState orderState) {
        Order updatedOrder = em.find(Order.class, order.getId());
        updatedOrder.setOrderState(orderState);
        return updatedOrder;
    }

    @Override
    public Order updateOrderCount(Order order, int count, int totalPrice) {
        Order updatedOrder = em.find(Order.class, order.getId());
        updatedOrder.setCount(count);
        updatedOrder.setTotalOrderPrice(totalPrice);
        return null;
    }

}
