package service.cafe.product.service;

import org.springframework.stereotype.Service;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

@Service
public class UpdateProductService {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product updateProduct(Product product, Long id) {
        return productRepository.update(product, id);
    }

}
