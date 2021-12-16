package service.cafe.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@DynamicUpdate
@NoArgsConstructor
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

    public Order(long userId, long productId, int itemCount) {
        this.userId = userId;
        this.productId = productId;
        this.itemCount = itemCount;
        this.canceled = false;
        this.orderState = OrderState.Payed;
    }

}
