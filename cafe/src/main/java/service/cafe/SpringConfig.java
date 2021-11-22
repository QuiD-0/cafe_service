package service.cafe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.cafe.product.repository.JpaProductRepository;
import service.cafe.product.repository.ProductRepository;
import service.cafe.user.controller.UserController;
import service.cafe.user.repository.JpaUserRepo;
import service.cafe.user.repository.UserRepository;
import service.cafe.user.service.UserService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserController userController() {
        return new UserController(userService());
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new JpaUserRepo(em);
    }

}
