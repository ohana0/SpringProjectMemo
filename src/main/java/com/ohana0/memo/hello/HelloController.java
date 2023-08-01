package com.ohana0.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String helloWorld() {

        return "helloWorld!";
    }
    
    @RequestMapping("/hello/jsp")
    public String helloJsp() {
    	return "/hello/hello";
    }
}