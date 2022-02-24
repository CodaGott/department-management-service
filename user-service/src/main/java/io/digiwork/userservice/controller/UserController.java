package io.digiwork.userservice.controller;

import io.digiwork.userservice.VO.ResponseTemplate;
import io.digiwork.userservice.model.User;
import io.digiwork.userservice.service.UserService;
import io.digiwork.userservice.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userService2;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        log.info("Create user controller");
        return userService.createUser(user);
    }

    @GetMapping("/{userid}")
    public ResponseTemplate getUserById(@PathVariable Long userid){
        log.info("Get user with department controller");
        return userService2.getUserWithDepartment(userid);
    }
}
