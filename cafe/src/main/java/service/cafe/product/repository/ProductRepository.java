package service.cafe.product.repository;

import service.cafe.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    boolean delete(Long id);

    Product update(Product product, Long id);

}
