package com.codeup.blog;

import com.codeup.blog.model.Post;
import com.codeup.blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PostRepository postDao;
    private final UserRepository userDao;

    @Value("${app.env}")
    private String environment;

    public DatabaseSeeder(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    private List<User> seedUsers() {
        List<User> users = Arrays.asList(
                new User("kelly@Kelly.com", "Kelly"),
                new User("emily@emily.com", "Emily"),
                new User("lande@lance.com", "Lance"),
                new User("nestor@nestor.com", "Nestor"),
                new User("john@john.com", "John")
        );
        userDao.save(users);
        return users;
    }

    private void seedPosts(List<User> users) {
        Post longPost = new Post(
                "Example 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"
        );

        List<Post> posts = Arrays.asList(
                new Post("title 1", "body 1"),
                new Post("title 2", "body 2"),
                new Post("title 3", "body 3"),
                new Post("title 4", "body 4"),
                longPost
                );
        Random r = new Random();
        for (Post p : posts){
            User randomUser = users.get(r.nextInt(users.size()));
            p.setUser(randomUser);
        }
        postDao.save(posts);

    }
    @Override
    public void run(String... strings) throws Exception{
        if(! environment.equals("development")){
            log.info("app.env is not development, doing nothing.");
            return;
        }
        log.info("Deleting Posts....");
        postDao.deleteAll();
        log.info("Deleting Users....");
        postDao.deleteAll();
        log.info("Seeding Users....");
        List<User> users = seedUsers();
        log.info("Seeding Posts....");
        seedPosts(users);
        log.info("Finished running seeders!");

    }
}
