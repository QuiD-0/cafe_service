package service.cafe.product.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class SaveProductServiceTest {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    SaveProductService saveProductService;

    Product alreadyExistItem = new Product("Americano", "가장 기본적인 커피", 3000, 10);
    Product notExistItem = new Product("Cake", "케이크", 4000, 10);

    @Test
    public void saveTestWhenAlreadyExist() {
        given(productRepository.save(any())).willReturn(false);

        Assertions.assertSame(saveProductService.newProduct(alreadyExistItem), false);
    }

    @Test
    public void saveTestWhenNotExist() {
        given(productRepository.save(any())).willReturn(true);

        Assertions.assertSame(saveProductService.newProduct(notExistItem), true);
    }
}
