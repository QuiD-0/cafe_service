package service.cafe.product.repository;

import org.springframework.stereotype.Repository;
import service.cafe.product.domain.Product;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductRepository {
    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() { return null; }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Product update(Product product, Long id) {
        return null;
    }
}
