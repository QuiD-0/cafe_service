package service.cafe.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.cafe.user.domain.User;
import service.cafe.user.repository.UserRepository;
import service.cafe.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @GetMapping("")
    public List<User> helloSpring() {
        List<User> users = userService.findUsers();
        return users; }

    @PostMapping("/new")
    public User newUser(@RequestBody User user){
        userService.join(user);
        return user;
    }

    @GetMapping(path = "/{userId}")
    public Optional<User> findUser(@PathVariable(name = "userId") Long id){
        Optional<User> user = userService.findOne(id);
        return user;
    }
    @PostMapping("/update")
    public User updateUser(@RequestBody User user){
        userService.updateUser(user);
        return user;
    }

}
