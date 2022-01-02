package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("portfolio")
    public String portfolio(){
        return "views/portfolio";
    }

    @GetMapping("talk")
    public String talk(){
        return "views/talk";
    }

    @GetMapping("warning")
    public String warning(){
        return "views/warning";
    }
}
