package com.codeup.blog;

import com.codeup.blog.model.User;
import com.codeup.blog.model.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = users.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("Couldn't find user w/ username:" + s);
        }
        return new UserWithRoles(user);
    }
}
