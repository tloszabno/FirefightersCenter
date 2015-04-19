package pl.edu.agh.integracja.firefighterspost.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class PostController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PostController.class, args);
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    String ping() {
        return "Hello World!";
    }


    @RequestMapping(value = "/alert", method = RequestMethod.POST)
    @ResponseBody
    String alert() {
        return "Alert!!!!";
    }
}

