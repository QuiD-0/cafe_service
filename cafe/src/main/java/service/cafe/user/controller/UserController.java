package service.cafe.user.controller;

import org.springframework.web.bind.annotation.*;
import service.cafe.user.domain.User;
import service.cafe.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> showUsers() {
        List<User> users = userService.findUsers();
        return users;
    }

    @PostMapping("")
    public User newUser(@RequestBody User user) {
        userService.join(user);
        return user;
    }

    @GetMapping(path = "/{userId}")
    public Optional<User> findUser(@PathVariable(name = "userId") Long id) {
        Optional<User> user = userService.findOne(id);
        return user;
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable(name = "userId") Long id) {
        userService.updateUser(user, id);
        return user;
    }

}
