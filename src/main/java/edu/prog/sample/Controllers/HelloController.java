package edu.prog.sample.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/Hello")
    String sayHello()
    {return "<h1>Hello World from controller</h1>";};
}
