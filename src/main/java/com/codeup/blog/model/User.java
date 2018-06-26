package com.codeup.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column (name ="username", nullable = false, length = 100)
    private String username;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column (name = "password", nullable = false, length = 100)
    private String password;

@OneToMany
private List<Post> posts;

    public User(long id, String username, String email, String pasword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = pasword;
    }

    public User(String email, String username) {
        this.email = email;
        this.password = username;
    }

    public User() { }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }


}
