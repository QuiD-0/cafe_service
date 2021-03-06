package service.cafe.user.repository;

import service.cafe.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    User update(User user, Long id);
}
