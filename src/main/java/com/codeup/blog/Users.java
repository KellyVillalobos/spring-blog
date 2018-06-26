package com.codeup.blog;

import com.codeup.blog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Users extends CrudRepository<User,Long> {
    List<User> findAll();
    User findByUsername(String username);
    User findUsersById(long id);

}
