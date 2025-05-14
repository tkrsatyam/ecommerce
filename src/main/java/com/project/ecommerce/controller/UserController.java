package com.project.ecommerce.controller;

import com.project.ecommerce.bean.UserBean;
import com.project.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserBean> userSignUp(@RequestBody UserBean user) {
        return ResponseEntity.ok(userService.signUp(user));
    }

    @GetMapping
    public ResponseEntity<UserBean> userLogin(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(userService.login(email, password));
    }
}
