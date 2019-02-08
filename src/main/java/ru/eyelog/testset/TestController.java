package ru.eyelog.testset;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/path")
    public String takeIt(){
        return "Good test";
    }
}
