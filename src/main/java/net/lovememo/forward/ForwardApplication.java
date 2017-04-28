package net.lovememo.forward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lovememo on 17-4-29.
 */
@RestController
@EnableAutoConfiguration
public class ForwardApplication {
    @RequestMapping("/")
    String index() {
        return "hello spring boot";
    }
    public static void main(String[] args) {
        SpringApplication.run(ForwardApplication.class, args);
    }
}
