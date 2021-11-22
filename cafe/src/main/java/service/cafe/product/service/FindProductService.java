package service.cafe.product.service;

import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class FindProductService {
    private final ProductRepository productRepository;

    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Optional<Product> findOne(Long id) {
        return productRepository.findById(id);
    }

    List<Product> findAll() {
        return productRepository.findAll();
    }

}
