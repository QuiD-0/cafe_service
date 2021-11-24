package service.cafe.product.service;

import org.springframework.stereotype.Service;
import service.cafe.product.repository.ProductRepository;

@Service
public class DeleteProductService {
    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean deleteProduct(Long id) {
        return productRepository.delete(id);
    }
}
