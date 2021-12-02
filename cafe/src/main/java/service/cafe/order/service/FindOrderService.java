package service.cafe.order.service;

import org.springframework.stereotype.Service;
import service.cafe.order.domain.Order;
import service.cafe.order.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FindOrderService {

    private final OrderRepository orderRepository;

    public FindOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findOneOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    public List<Order> findDoneOrder() {return orderRepository.findDoneOrder();}

    public List<Order> findOrdersByUserId(Long id) {
        return orderRepository.findByUserId(id);
    }

}
