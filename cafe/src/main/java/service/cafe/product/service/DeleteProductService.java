package service.cafe.product.service;

import service.cafe.product.repository.ProductRepository;

public class DeleteProductService {
    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    boolean delete_Product(Long id){
        return productRepository.delete(id);
    }
}
