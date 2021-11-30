package service.cafe.product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

@SpringBootTest
public class UpdateProductRepoTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    public void updateProductTest() {
        Product product = productRepository.findById(4L).get();

        Assertions.assertEquals(product.getName(), "Americano");
        Assertions.assertEquals(product.getPrice(), 10000);
        Assertions.assertEquals(product.getRemain(), 10);

        product.setName("Coffee");
        product.setPrice(3000);

        productRepository.update(product, product.getId());
        Product newProduct = productRepository.findById(product.getId()).get();

        Assertions.assertEquals(newProduct.getName(), "Coffee");
        Assertions.assertEquals(newProduct.getPrice(), 3000);
        Assertions.assertEquals(newProduct.getRemain(), newProduct.getRemain());

    }
}
