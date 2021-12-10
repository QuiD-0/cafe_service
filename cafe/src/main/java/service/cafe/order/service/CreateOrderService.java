package service.cafe.order.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.order.domain.Order;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.domain.Product;
import service.cafe.product.service.FindProductService;
import service.cafe.product.service.UpdateProductService;

import java.time.LocalDateTime;

@Service
public class CreateOrderService {

    private final OrderRepository orderRepository;
    private final FindProductService findProductService;
    private final UpdateProductService updateProductService;

    public CreateOrderService(OrderRepository orderRepository, FindProductService findProductService, UpdateProductService updateProductService) {
        this.orderRepository = orderRepository;
        this.findProductService = findProductService;
        this.updateProductService = updateProductService;
    }

    @Transactional
    public Order createOrder(Order order) {
        try {
            Product buyItem = findProductService.findOne(order.getProductId());
            if (buyItem.getRemain() >= order.getCount()) {
                buyItem.setRemain(buyItem.getRemain() - order.getCount());
                updateProductService.updateProduct(buyItem, buyItem.getId());
                order.setTotalOrderPrice(buyItem.getPrice() * order.getCount());
                LocalDateTime date = LocalDateTime.now();
                order.setOrderTime(date);
                return orderRepository.save(order);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
