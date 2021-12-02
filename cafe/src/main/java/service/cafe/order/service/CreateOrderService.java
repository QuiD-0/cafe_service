package service.cafe.order.service;

import org.springframework.stereotype.Service;
import service.cafe.order.domain.Order;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.repository.ProductRepository;

import java.util.Date;

@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public CreateOrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Boolean createOrder(Order order) {
        int productPrice = productRepository.findById(order.getProductId()).get().getPrice();
        order.setTotalOrderPrice(productPrice * order.getCount());
        order.setOrderTime(new Date());
        System.out.println(order);
        return orderRepository.save(order);
    }

}
