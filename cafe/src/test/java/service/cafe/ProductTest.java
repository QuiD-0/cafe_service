package service.cafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.cafe.product.service.FindProductService;

@SpringBootTest
public class ProductTest {

    @Autowired FindProductService findProductService;

    @Test
    void findTest(){
        findProductService.findAll();
    }
}
