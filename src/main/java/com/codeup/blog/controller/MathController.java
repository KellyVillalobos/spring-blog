package com.codeup.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{number1}/and/{number2}")
        public @ResponseBody String Add(@PathVariable Integer number1,
                                         @PathVariable Integer number2){

        return String.format("%d + %d = %d", number1, number2, number1 + number2);
    }

    @GetMapping("/subtract/{number1}/from/{number2}")
    public @ResponseBody String Subtract(@PathVariable  Integer number1,
                                     @PathVariable Integer number2){

        return String.format("%d - %d = %d", number1, number2, number1 - number2);
    }
    @GetMapping("/multiply/{number1}/and/{number2}")
    public @ResponseBody String Multiply(@PathVariable Integer number1,
                                     @PathVariable Integer number2){

        return String.format("%d * %d = %d", number1, number2, number1 * number2);
    }

    @GetMapping("/divide/{number1}/and/{number2}")
    public @ResponseBody String Divide(@PathVariable Integer number1,
                                     @PathVariable Integer number2){

        return String.format("Your Answer Is: %s", number1, number2, number1 / number2);
    }



}
