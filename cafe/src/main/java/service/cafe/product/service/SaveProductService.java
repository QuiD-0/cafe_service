package service.cafe.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

@Service
public class SaveProductService {
    private final ProductRepository productRepository;

    public SaveProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product newProduct(Product product) {
        return productRepository.save(product);
    }
}
