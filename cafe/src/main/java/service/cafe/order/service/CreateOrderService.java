package service.cafe.order.service;

import org.springframework.stereotype.Service;
import service.cafe.order.domain.Order;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CreateOrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(Order order) {
        int productPrice = productRepository.findById(order.getProductId()).get().getPrice();
        order.setTotalOrderPrice(productPrice * order.getCount());
        LocalDateTime date = LocalDateTime.now();
        order.setOrderTime(date);
        return orderRepository.save(order);
    }

}