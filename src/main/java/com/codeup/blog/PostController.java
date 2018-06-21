package com.codeup.blog;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

    @GetMapping("/posts")
    public String Index(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "/posts/index";
    }

    @GetMapping("/post/{id}")
    public String ShowDetails(@PathVariable long id, Model view) {
        view.addAttribute("post", postService.findOne(id));
        return "/posts/show";


    }

    @GetMapping("/post/{id}/edit")
    public String Edit(@ModelAttribute Post post, @PathVariable long id, Model view) {
        view.addAttribute("id", id);
        //findOne
        Post post1 = postService.findOne(id);
        //viewatt Post object
        view.addAttribute("post",post1);

        return "/posts/edit";

    }

    @PostMapping("post/create")
    public String create(@ModelAttribute Post post) {
        System.out.println(post);
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/post/create")
    public String showCreateForm(Model view) {
        view.addAttribute("post", new Post());
        return "/posts/create";
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:posts/index";
    }

}
