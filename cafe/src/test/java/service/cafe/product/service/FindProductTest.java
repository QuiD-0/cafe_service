package service.cafe.product.service;

import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class FindProductTest {

    @Autowired
    FindProductService findProductService;

    @MockBean
    ProductRepository productRepository;

    @Test
    void testFindProductWhenProductExists() {
        var givenProduct = new Product("1", "2", 3, 4);

        given(productRepository.findById(anyLong())).willReturn(Optional.of(givenProduct));

        var product = Assertions.assertDoesNotThrow(() -> findProductService.findOne(46L));
        Assertions.assertEquals(givenProduct, product);
    }

    @Test
    void testFindProductWhenProductNotExists() {
        given(productRepository.findById(anyLong())).willReturn(Optional.empty());

        var exception = Assertions.assertThrows(NotFoundException.class, () -> findProductService.findOne(4L));

        Assertions.assertSame(exception.getClass(), NotFoundException.class);
        Assertions.assertSame(exception.getMessage(), "Not Found");
    }

    @Test
    void testFindAllProductWhenProductExists() {
        List<Product> givenProducts = new ArrayList<>() {
            {
                add(new Product("1", "2", 3, 4));
                add(new Product("5", "6", 7, 8));
            }
        };
        given(productRepository.findAll()).willReturn(givenProducts);

        var products = Assertions.assertDoesNotThrow(() -> findProductService.findAll());
        Assertions.assertEquals(givenProducts, products);
    }

    @Test
    void testFindAllProductWhenProductNotExists() {
        given(productRepository.findAll()).willReturn(null);
        var result = productRepository.findAll();
        Assertions.assertNull(result);
    }
}
