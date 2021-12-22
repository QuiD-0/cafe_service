package service.cafe.user.controller;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import service.cafe.advice.exceptions.UserNameNotExistsException;
import service.cafe.advice.exceptions.UserNotFoundException;
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

    @GetMapping
    public List<User> showUsers() throws NotFoundException {
        List<User> users = userService.findUsers();
        if (users == null) {
            throw new NotFoundException("Not Found");
        }
        return users;
    }

    @PostMapping
    public User newUser(@RequestBody User user) throws UserNameNotExistsException {
        if (user.getName() == null) {
            throw new UserNameNotExistsException();
        }
        userService.join(user);
        return user;
    }

    @GetMapping("/{userId}")
    public User findUser(@PathVariable(name = "userId") Long id) throws UserNotFoundException {
        Optional<User> user = userService.findOne(id);
        return user.orElseThrow(() -> new UserNotFoundException());
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable(name = "userId") Long id) {
        userService.updateUser(user, id);
        return user;
    }

}
