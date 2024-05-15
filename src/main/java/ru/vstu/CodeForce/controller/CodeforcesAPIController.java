package ru.vstu.CodeForce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.vstu.CodeForce.model.ContestRating;
import ru.vstu.CodeForce.handle.CodeforcesAPIHandler;
import ru.vstu.CodeForce.model.User;
import ru.vstu.CodeForce.service.UserService;

import java.util.List;


@RestController
public class CodeforcesAPIController {

    private final CodeforcesAPIHandler codeforcesAPIHandler;
    private final UserService userService;

    @Autowired
    public CodeforcesAPIController(CodeforcesAPIHandler codeforcesAPIHandler, UserService userService) {
        this.codeforcesAPIHandler = codeforcesAPIHandler;
        this.userService = userService;
    }


    @GetMapping("/userInfo")
    public String getUserInfo(@RequestParam(name = "handle") String handle) {
        return codeforcesAPIHandler.getUserInfo(handle);
    }

    @PostMapping("/userInfo")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUserInfo(@RequestParam(name = "handle") String handle) {
        return userService.create(codeforcesAPIHandler.jsonToUser(handle));
    }

    @GetMapping("/userRating")
    public String getUserRating(@RequestParam(name = "handle") String handle) {
        return codeforcesAPIHandler.getUserRating(handle);
    }

    @PostMapping("/userRating")
    public List<ContestRating> saveUserRating(@RequestParam(name = "handle") String handle) {
        return codeforcesAPIHandler.jsonToRatingList(handle);
    }
}
