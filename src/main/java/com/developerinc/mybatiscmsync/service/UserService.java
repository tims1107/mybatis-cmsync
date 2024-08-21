package com.developerinc.mybatiscmsync.service;

import com.developerinc.mybatiscmsync.mappers.UserMapper;
import com.developerinc.mybatiscmsync.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void init() {
        if (userMapper == null) {
            logger.error("UserMapper is not injected!");
        } else {
            logger.info("UserMapper is successfully injected!");
        }
    }

    public List<User> getAllUsers() {
        try {
            List<User> users = userMapper.findAll();
            if (users == null) {
                logger.warn("UserMapper returned null");
                throw new RuntimeException("User list is null");
            }
            return users;
        } catch (Exception e) {
            logger.error("Exception occurred while retrieving users", e);
            throw new RuntimeException("Failed to retrieve users", e);
        }
    }
}