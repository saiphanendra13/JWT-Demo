package com.jwt.controllers;

import com.jwt.entities.User;
import com.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //POST create user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = this.userService.createUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);

    }

    //PUT Mapping
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") Integer uid) {
        User updatedUser = this.userService.updateUser(user, uid);
        return ResponseEntity.ok(updatedUser);

    }


    //ADMIN

    //Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer uid) {

        this.userService.deleteUser(uid);

        return new ResponseEntity("User deleted Successfully", HttpStatus.OK);

    }

    //Get user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {

        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


}
