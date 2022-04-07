package no.ntnu.xxs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting() {
        return "Hello, endpoint is reachable for everyone";
    }
}
