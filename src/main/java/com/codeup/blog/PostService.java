package com.codeup.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    public static void main(String[] args) {

    }

    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        System.out.println("hi from save method");
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    private void createPosts() {
        // create some ad objects and add them to the ads list
        // with the save method



        Post post1 = new Post("First post from the post service", "This body is coming from the first post the post service", 1);
        Post post2 = new Post("Second post from the post service", "this body is coming from the second post of the post service",2);
        Post post3 = new Post("Third post from the post service", "This body is coming from the Third post of the post service", 3);
        Post post4 = new Post("Fourth post from the post service", "This body is coming from the Fourth post of the post service", 4);
        Post post5 = new Post("Fifth post from the post service", "This body is coming from the Fifth post of the post service", 5);
        Post post6 = new Post("Sixth post from the post service", "This body is coming from the Sixth post of the post service", 6);
        Post post7 = new Post("Seventh post from the post service", "This body is coming from the Seventh post of the post service", 7);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
        posts.add(post7);


    }
}

