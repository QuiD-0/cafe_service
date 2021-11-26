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
        em.persist(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select m from Product m", Product.class).getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public boolean delete(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
        return true;
    }

    @Override
    public Product update(Product product, Long id) {
        Product newProduct = em.find(Product.class,id);
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setRemain(product.getRemain());
        return newProduct;
    }
}
