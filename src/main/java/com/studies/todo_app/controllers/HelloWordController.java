package com.studies.todo_app.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @GetMapping("/helloWord")
    public String helloWord(@RequestParam(name = "nome") String name) {
        return "Hello " + name;
    }
}
