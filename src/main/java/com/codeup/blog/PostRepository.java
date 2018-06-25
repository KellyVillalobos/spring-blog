package com.codeup.blog;

import com.codeup.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findAll();
    List<Post> findByBodyContainsOrTitleContains(String searchTerm, String searchTerm2);
    Post findById(long id);
}
