package de.bot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetHelloController {

    @GetMapping("/")
    public String getHello() {
        return "Hello I'm alive";
    }
}
