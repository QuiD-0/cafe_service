package service.cafe.product.service;

import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

public class SaveProductService {
    private final ProductRepository productRepository;

    public SaveProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Product new_Product(Product product) {
        return productRepository.save(product);
    }
}
