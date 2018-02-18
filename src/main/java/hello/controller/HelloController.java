package hello.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
