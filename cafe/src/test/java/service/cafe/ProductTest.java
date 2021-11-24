package service.cafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.service.FindProductService;
import service.cafe.product.service.SaveProductService;

import java.util.List;

@SpringBootTest
@Transactional
public class ProductTest {

    @Autowired FindProductService findProductService;
    @Autowired SaveProductService saveProductService;

    @Test
    void findTest(){
        List<Product> items = findProductService.findAll();
        System.out.println("items = " + items);
    }

    @Test
    void saveTest(){
        Product item = new Product("Americano","가장 기본적인 커피",10000,10);
        saveProductService.newProduct(item);
    }
}
