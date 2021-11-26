package service.cafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.service.DeleteProductService;
import service.cafe.product.service.FindProductService;
import service.cafe.product.service.SaveProductService;
import service.cafe.product.service.UpdateProductService;

@SpringBootTest
@Transactional
public class ProductTest {

    @Autowired
    FindProductService findProductService;
    @Autowired
    SaveProductService saveProductService;
    @Autowired
    UpdateProductService updateProductService;
    @Autowired
    DeleteProductService deleteProductService;

    @Test
    void testFindProductWhenProductExists() {
//        Optional<Product> item = findProductService.findOne(4L);
//        Assertions.assertThat(item.get().getName()).isEqualTo("Americano");
    }

    @Test
    void testFindProductWhenProductNotExists() {
//        Optional<Product> item = findProductService.findOne(4L);
//        Assertions.assertThat(item.get().getName()).isEqualTo("Americano");
    }

    @Test
    void saveTest() {
        Product item = new Product("Americano", "가장 기본적인 커피", 10000, 10);
        saveProductService.newProduct(item);
    }

    @Test
    void updateTest() {
        Product newItem = new Product("Americano", "에스프레소에 물을 탄 커피", 3000, 10);
        updateProductService.updateProduct(newItem, 4L);
    }

    @Test
    void deleteTest() {
        deleteProductService.deleteProduct(4L);
    }
}
