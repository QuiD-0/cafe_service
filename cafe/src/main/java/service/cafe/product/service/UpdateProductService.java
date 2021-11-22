package service.cafe.product.service;

import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

public class UpdateProductService {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Product update(Product product, Long id) {
        return productRepository.update(product, id);
    }

}
