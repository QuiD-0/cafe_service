package service.cafe.product.service;

import org.springframework.stereotype.Service;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FindProductService {
    private final ProductRepository productRepository;

    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findOne(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
