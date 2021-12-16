package service.cafe.order.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.order.domain.Order;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;
import service.cafe.product.service.FindProductService;
import service.cafe.product.service.UpdateProductService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UpdateProductService updateProductService;

    public CreateOrderService(OrderRepository orderRepository, ProductRepository productRepository, UpdateProductService updateProductService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.updateProductService = updateProductService;
    }

    @Transactional
    public Order createOrder(Order order) {
        Product buyItem = productRepository.findById(order.getProductId()).get();
        if (buyItem.getRemain() >= order.getItemCount()) {
            buyItem.setRemain(buyItem.getRemain() - order.getItemCount());
            updateProductService.updateProduct(buyItem, buyItem.getId());
            order.setTotalOrderPrice(buyItem.getPrice() * order.getItemCount());
            LocalDateTime date = LocalDateTime.now();
            order.setOrderTime(date);
            return orderRepository.save(order);
        }
        return null;
    }

}
