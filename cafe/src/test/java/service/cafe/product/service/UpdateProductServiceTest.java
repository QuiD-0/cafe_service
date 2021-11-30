package service.cafe.product.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class UpdateProductServiceTest {

    @Autowired
    UpdateProductService updateProductService;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void updateProductServiceTest() {
        Product updatedItem = new Product("coffee", "커피", 4000, 100);
        given(productRepository.update(any(), anyLong())).willReturn(updatedItem);

        Product newProduct = updateProductService.updateProduct(new Product("1", "2", 3, 4), 123L);
        Assertions.assertEquals(newProduct.getName(), "coffee");
    }
}
