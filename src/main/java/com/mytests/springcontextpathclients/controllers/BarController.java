package com.mytests.springcontextpathclients.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BarController {

    @GetMapping("/bar/test3")
    public String bartest3() {
        return "bar/test3";
    }

    @GetMapping("/bar/test4")
    public String bartest4() {
        return "bar/test4";
    }
}
