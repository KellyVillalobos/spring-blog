package com.codeup.blog.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserWithRoles extends User implements UserDetails {


    public UserWithRoles(User user) {
        //pass on to user class in the copy.id
        super(user);  // Call the copy constructor defined in User
    }

    //moderator
    //admin
    //editor
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = "e"; // Since we're not using the authorization part of the component
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
