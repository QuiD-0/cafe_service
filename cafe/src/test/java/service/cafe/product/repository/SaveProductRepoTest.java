package service.cafe.product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.Optional;

@SpringBootTest
public class SaveProductRepoTest {

    @Autowired
    ProductRepository productRepository;

    Product Item = new Product("Cake", "케이크", 4000, 10);

    @Test
    @Transactional
    public void SaveTest() {
        productRepository.save(Item);
        Optional<Product> findItem = productRepository.findByName("Cake");

        Assertions.assertEquals(findItem.get().getName(), "Cake");
        Assertions.assertEquals(findItem.get().getDescription(), "케이크");
        Assertions.assertEquals(findItem.get().getPrice(), 4000);
        Assertions.assertEquals(findItem.get().getRemain(), 10);
    }

}
