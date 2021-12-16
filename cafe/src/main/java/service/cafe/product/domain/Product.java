package service.cafe.product.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@DynamicUpdate
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private int remain;

    public Product(String name, String description, int price, int remain) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.remain = remain;
    }
}
