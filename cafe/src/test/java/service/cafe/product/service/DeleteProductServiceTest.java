package service.cafe.product.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import service.cafe.product.repository.ProductRepository;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class DeleteProductServiceTest {

    @Autowired
    DeleteProductService deleteProductService;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void deleteServiceTest() {
        given(productRepository.delete(anyLong())).willReturn(true);

        Assertions.assertSame(deleteProductService.deleteProduct(123L), true);
    }
}
