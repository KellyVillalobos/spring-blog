package com.codeup.blog;

import com.codeup.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private Users userDao;

    public UserService(Users userDao) {
        this.userDao = userDao;
    }

    public User findRandomUser(){
        List<User> users = userDao.findAll();
        Random r = new Random();

        return users.get(r.nextInt(users.size()));
    }

    public User findUserById(long id){
        return userDao.findUsersById(id);
    }

    public User save(User user){
        return userDao.save(user);
    }


}
