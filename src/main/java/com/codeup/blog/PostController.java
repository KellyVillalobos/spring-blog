package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;

    }

    @GetMapping("/posts")
    public String Index(PostService postService, Model model) {
        //make an arraylist of post objects to send to the view.
//        List<Post> posts = new ArrayList<>();
//        Post post1 = new Post(
//                "Title form array of posts", "This is the first post of the array", 1
//        );
//        Post post2 = new Post(
//                "Title from array of posts", "This is the second post of the array", 2
//        );
//        posts.add(post1);
//        posts.add(post2);
        model.addAttribute("posts", postService.findAll());

        return "/posts/index";

    }

    @GetMapping("/post/{id}")
    public String ShowDetails(@PathVariable long id, PostService postService, Model view) {
//        Post post = new Post("This is a single post", "This is the post body", id);
        view.addAttribute("post", postService.findOne(id));
        return "/posts/show";


    }

    @GetMapping("/posts/{id}/edit")
    public @ResponseBody
    String Edit(@PathVariable long id) {
        return "View the form for editing post #" + id;

    }
//
//    @GetMapping("/posts/create")
//    public
//    String Create(Model view) {
//
//        return "/posts/create";
//
//    }

    @GetMapping("com.codeup.blog.Post/create")
    public @ResponseBody
    String savePost() {
        return "saving to the database";
    }

}
