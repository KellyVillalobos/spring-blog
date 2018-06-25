package com.codeup.blog;

import com.codeup.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private UserRepository userDao;

    public UserService(UserRepository postDao) {
        this.userDao = postDao;
    }

    public User findRandomUser(){
        List<User> users = userDao.findAll();
        Random r = new Random();

        return users.get(r.nextInt(users.size()));
    }
}
