package com.codeup.blog;

import com.codeup.blog.model.Post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postDao;


    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public List<Post> search(String searchTerm) {
       return postDao.findByBodyContainsOrTitleContains(searchTerm, searchTerm);
       }


    public List<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
        postDao.save(post);
        return post;
    }

    public void delete(long id) {
        postDao.delete(id);
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }

    public Post edit(Post post, long id) {

        return postDao.save(post);

    }

    private void createPosts() {
        // create some ad objects and add them to the ads list
        // with the save method


//        Post post1 = new Post("First post from the post service", "This body is coming from the first post the post service", 1);
//        Post post2 = new Post("Second post from the post service", "this body is coming from the second post of the post service",2);
//        Post post3 = new Post("Third post from the post service", "This body is coming from the Third post of the post service", 3);
//        Post post4 = new Post("Fourth post from the post service", "This body is coming from the Fourth post of the post service", 4);
//        Post post5 = new Post("Fifth post from the post service", "This body is coming from the Fifth post of the post service", 5);
//        Post post6 = new Post("Sixth post from the post service", "This body is coming from the Sixth post of the post service", 6);
//        Post post7 = new Post("Seventh post from the post service", "This body is coming from the Seventh post of the post service", 7);
//        posts.add(post1);
//        posts.add(post2);
//        posts.add(post3);
//        posts.add(post4);
//        posts.add(post5);
//        posts.add(post6);
//        posts.add(post7);


    }
}

