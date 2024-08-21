package com.developerinc.mybatiscmsync.controller;

import com.developerinc.mybatiscmsync.model.User;
import com.developerinc.mybatiscmsync.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<String> getAllUsers() {
        try {
            logger.info("getAllUsers endpoint called");
            List<User> userList = userService.getAllUsers();
            if (userList == null) {
                throw new RuntimeException("User list is null");
            }
            return ResponseEntity.ok(userList.toString());
        } catch (RuntimeException e) {
            logger.error("RuntimeException: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to retrieve users: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Exception: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving users: " + e.getMessage());
        }
    }
}