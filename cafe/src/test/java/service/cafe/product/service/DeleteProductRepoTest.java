package service.cafe.product.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.Optional;

@SpringBootTest
public class DeleteProductRepoTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    public void DeleteRepoTest() {
        Optional<Product> item = productRepository.findByName("Americano");
        Assertions.assertSame(Product.class, item.get().getClass());

        productRepository.delete(item.get().getId());
        Assertions.assertSame(Optional.empty(), productRepository.findByName("Americano"));
    }

}
