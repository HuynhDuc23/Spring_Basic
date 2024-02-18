package vn.spring.projectbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.spring.projectbase.service.EmailServiceInterface;

@RestController
@RequestMapping("/api")
public class ControllerCheckScope {
    private EmailServiceInterface emailServiceInterface1 ;
    private EmailServiceInterface emailServiceInterface2 ;

    @Autowired
    public ControllerCheckScope(EmailServiceInterface emailServiceInterface1, EmailServiceInterface emailServiceInterface2) {
        this.emailServiceInterface1 = emailServiceInterface1;
        this.emailServiceInterface2 = emailServiceInterface2;
    }
    @GetMapping("/check")
    public String check(){
        return "Result" + (this.emailServiceInterface1==this.emailServiceInterface2);
    }
    @GetMapping("/check2")
    public String checkSingletonOfPrototype()
    {
        if((this.emailServiceInterface1==this.emailServiceInterface2)){
           return "SINGLETON";
        }
        else {
           return "PROTOTYPe";
        }
    }
}
