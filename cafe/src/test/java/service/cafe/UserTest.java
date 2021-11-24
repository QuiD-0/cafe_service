package service.cafe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.cafe.user.domain.User;
import service.cafe.user.repository.UserRepository;
import service.cafe.user.service.UserService;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserTest {
    @Autowired UserService userService;

    @Test
    void 회원가입(){
        User user = new User("user1",0,false);
        userService.join(user);
    }
}
