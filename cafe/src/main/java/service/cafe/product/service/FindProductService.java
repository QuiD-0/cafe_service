package service.cafe.product.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import service.cafe.product.domain.Product;
import service.cafe.product.repository.ProductRepository;

import java.util.List;

@Service
public class FindProductService {
    private final ProductRepository productRepository;

    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findOne(Long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("123123"));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
