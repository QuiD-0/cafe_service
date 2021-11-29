package service.cafe.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.Optional;

@Service
public class SaveProductService {
    private final ProductRepository productRepository;

    public SaveProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public boolean newProduct(Product product) {
        Optional<Product> item = productRepository.findByName(product.getName());
        if (item.isEmpty()) {
            return productRepository.save(product);
        } else {
            return false;
        }
    }
}
