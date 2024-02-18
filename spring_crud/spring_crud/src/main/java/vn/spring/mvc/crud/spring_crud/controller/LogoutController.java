package vn.spring.mvc.crud.spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
    @GetMapping("/logout_controller")
    public String handleLogout() {
        return "logout/logout";
    }
}
