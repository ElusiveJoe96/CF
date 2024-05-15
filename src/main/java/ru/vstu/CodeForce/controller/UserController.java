package ru.vstu.CodeForce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vstu.CodeForce.model.User;
import ru.vstu.CodeForce.service.UserService;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserInfoById(@PathVariable Long id) {
        return userService.getById(id);
    }
}
