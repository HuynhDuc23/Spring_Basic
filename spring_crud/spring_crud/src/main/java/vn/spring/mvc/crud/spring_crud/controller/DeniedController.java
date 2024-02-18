package vn.spring.mvc.crud.spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeniedController {
    @GetMapping("/403")
    public String get403(){
        return "/403/403";
    }
}
