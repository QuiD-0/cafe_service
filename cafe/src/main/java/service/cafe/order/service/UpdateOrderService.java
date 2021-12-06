package service.cafe.order.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.order.domain.Order;
import service.cafe.order.domain.OrderState;
import service.cafe.order.repository.OrderRepository;
import service.cafe.product.service.FindProductService;

@Service
public class UpdateOrderService {

    private final OrderRepository orderRepository;
    private final FindProductService findProductService;

    public UpdateOrderService(OrderRepository orderRepository, FindProductService findProductService) {
        this.orderRepository = orderRepository;
        this.findProductService = findProductService;
    }

    @Transactional
    public Order changeOrderState(Order order, OrderState orderState) {
        if (order.getOrderState() == OrderState.Canceled) {
            return order;
        } else {
            return orderRepository.updateOrderState(order, orderState);
        }
    }

    @Transactional
    public Order changeOrderProductCount(Order order, int count) {
        int totalPrice = 0;
        try {
            totalPrice = findProductService.findOne(order.getProductId()).getPrice() * count;
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return orderRepository.updateOrderCount(order, count, totalPrice);
    }

    @Transactional
    public Order CancelOrder(Order order) {
        return orderRepository.delete(order);
    }

}
