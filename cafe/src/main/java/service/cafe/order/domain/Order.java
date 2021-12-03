package service.cafe.order.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table(name = "purchase_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long productId;
    private int itemCount;
    private int totalOrderPrice;
    private LocalDateTime orderTime;
    private OrderState orderState;
    private boolean canceled;
    private LocalDateTime cancelTime;

    public Order() {
    }

    public Order(long userId, long productId, int itemCount) {
        this.userId = userId;
        this.productId = productId;
        this.itemCount = itemCount;
        this.canceled = false;
        this.orderState = OrderState.Payed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return itemCount;
    }

    public void setCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userId=" + userId + ", productId=" + productId + ", itemCount=" + itemCount + ", totalOrderPrice=" + totalOrderPrice + ", orderTime=" + orderTime + ", orderState=" + orderState + ", canceled=" + canceled + ", cancelTime=" + cancelTime + '}';
    }

}
