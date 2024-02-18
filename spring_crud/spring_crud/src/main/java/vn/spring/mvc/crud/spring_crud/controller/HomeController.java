package vn.spring.mvc.crud.spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/showpage1")
    public String homePage(){
        return "home/home_login";
    }
}
