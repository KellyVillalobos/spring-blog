package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDice {
    private List<String> rollList = new ArrayList<>();

    @GetMapping("/roll-dice")
    public String guess() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String guessNum(@PathVariable Integer number, Model model) {
        model.addAttribute("number", number);
        int random1 = (int) (Math.random() * (6 - 1) + 1);
        int random2 = (int) (Math.random() * (6 - 1) + 1);
        model.addAttribute("random1", random1);
        model.addAttribute("random2", random2);
        rollList(random1, random2);
        if (number.equals(random1) || number.equals(random2)){
            rollList.clear();
        }

        model.addAttribute("rolls", rollList);
        System.out.println(rollList);

        return "roll-dice";
    }

    private void rollList(Integer random1, Integer random2) {

        rollList.add(String.format("%d and %d, ", random1, random2));

    }


}
