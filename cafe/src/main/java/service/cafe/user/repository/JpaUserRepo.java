package service.cafe.user.repository;

import service.cafe.user.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepo implements UserRepository {

    private final EntityManager em;

    public JpaUserRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User users = em.find(User.class, id);
        return Optional.ofNullable(users);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class).getResultList();
    }

    @Override
    public User update(User user, Long id) {
        User newUser = em.find(User.class, id);
        newUser.setName(user.getName());
        newUser.setCash(user.getCash());
        newUser.setAdmin(user.isAdmin());
        return newUser;
    }
}
