package com.codeup.blog.controller;

import com.codeup.blog.Service.PostService;
import com.codeup.blog.Service.UserService;
import com.codeup.blog.model.Post;
import com.codeup.blog.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;
    private final  UserService userService;


    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;


    }


    @GetMapping("/posts")
    public String Index(Model view, @RequestParam(name = "search", required = false) String searchTerm) {
        List<Post> posts;
        if (searchTerm != null) {
            posts = postService.search(searchTerm);
        } else {

            posts = postService.findAll();

        }

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserById(sessionUser.getId());
        System.out.println(user.getId());
        view.addAttribute("user",user);
        view.addAttribute("posts", posts);
        view.addAttribute("searchTerm", searchTerm);
        return "/posts/index";
    }

    @GetMapping("/post/{id}")
    public String ShowDetails(@PathVariable long id, Model view) {
        view.addAttribute("post", postService.findById(id));
        System.out.println(postService.findById(id));
        return "/posts/show";


    }

    @GetMapping("/post/{id}/edit")
    public String showEditForm(@ModelAttribute Post post, @PathVariable long id, Model view) {

        view.addAttribute("id", id);
        Post p = postService.findOne(id);
        view.addAttribute("post", p);
        return "/posts/edit";

    }

    @PostMapping("/post/{id}/edit")
    public String Edit(@ModelAttribute Post post, @PathVariable long id, Model view) {

        postService.edit(post, id);

        view.addAttribute("posts", post);
        return "redirect:/posts";

    }

    @GetMapping("/post/{id}/delete")
    public String delete(@ModelAttribute Post post, @PathVariable long id, Model view) {
        postService.delete(id);
        return "redirect:/posts";
    }

    @PostMapping("post/create")
    public String create(@ModelAttribute Post post) {

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
