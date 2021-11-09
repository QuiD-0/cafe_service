package service.cafe.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.cafe.user.domain.User;
import service.cafe.user.repository.UserRepository;
import service.cafe.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @GetMapping("")
    public String helloSpring() {
        User user = new User("test3",0,false);
        userService.join(user);
        return "Hello user"; }

}
