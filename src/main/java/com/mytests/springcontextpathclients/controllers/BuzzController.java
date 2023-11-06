package com.mytests.springcontextpathclients.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuzzController {

    @GetMapping("/buzz/test1")
    public String test1() {
        return "buzz test1";
    }

    @GetMapping("/buzz/test2")
    public String test2() {
        return "buzz test2";
    }
}
