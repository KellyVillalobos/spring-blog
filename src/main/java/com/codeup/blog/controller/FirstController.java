package com.codeup.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    @GetMapping("/say-hello")
    public @ResponseBody String myFirstSpringView(){
        return "hello from Spring!";
    }

    @GetMapping("/say-hello/{name}")
    public @ResponseBody String sayHello(@PathVariable String name){
        return String.format("hello, %s!", name);
    }

    @GetMapping("/flights/from/{from}/to/{to}")
    public @ResponseBody String getFlights(
            @PathVariable String from,
            @PathVariable String to
    ){
        return String.format("Finding flights from %s to %s...", from, to);
    }

    @GetMapping("/say-goodbye")
    public @ResponseBody String MySecondSpringView(){
        return "Goodbye World!";
    }
}
