package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by fitri.nur61 on 9/19/2018.
 */
@Controller
public class PageController {
    @RequestMapping("/viral")
    public String viral() {
        return "viral";
    }

    @RequestMapping("/challenge")
    public String challenge(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "challenge";
    }

    @RequestMapping(value = {"/challenge", "challenge/{name}"})
    public String challengePath(@PathVariable Optional<String> name, Model model) {
        if (name.isPresent()) {
            model.addAttribute("name", name.get());
        } else {
            model.addAttribute("name", "KB");
        }
        return "challenge";
    }

    @RequestMapping(value = "/generator")
    public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") Integer a,
                            @RequestParam(value = "b", required = false, defaultValue = "0") Integer b,
                            Model model) {
        String hm = "hm";

        if (a > 1){
            for(int i = a;i>1;i--)
                hm += "m";
        }

        String hms = hm;

        if (b > 1) {
            for (int j = b;j>1;j--)
                hms += " " + hm + " ";
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("outs", hms);

        return "generator";
    }

}

