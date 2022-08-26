package com.example.demoserver.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "/")
public class RootController {

    @GetMapping()
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
