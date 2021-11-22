package service.cafe.user.service;

import org.springframework.transaction.annotation.Transactional;
import service.cafe.user.domain.User;
import service.cafe.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public User updateUser(User user, Long id) {
        return userRepository.update(user, id);
    }
}
