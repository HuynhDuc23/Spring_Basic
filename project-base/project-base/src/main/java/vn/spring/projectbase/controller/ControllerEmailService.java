package vn.spring.projectbase.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.spring.projectbase.service.EmailServiceImp;
import vn.spring.projectbase.service.EmailServiceInterface;
import vn.spring.projectbase.service.ZaloServiceImp;

@RestController
@RequestMapping("/api-email")
public class ControllerEmailService {
    private EmailServiceInterface emailServiceInterface ;

    private EmailServiceInterface emailServiceInterface2 ;
    private EmailServiceInterface emailServiceInterface3 ;
//    @Autowired
//    public ControllerEmailService(@Qualifier("ssmsServiceImp") EmailServiceInterface emailServiceInterface
//    , EmailServiceImp emailServiceInterface2, ZaloServiceImp emailServiceInterface3
//                                   ){
//        this.emailServiceInterface = emailServiceInterface;
//        this.emailServiceInterface2 = emailServiceInterface2 ;
//        this.emailServiceInterface3 = emailServiceInterface3 ;
//
//    }
 //   @Autowired
//    public ControllerEmailService(@Qualifier("ssmsServiceImp") EmailServiceInterface emailServiceInterface)
//    {
//        this.emailServiceInterface = emailServiceInterface;
//
//    }
    @PostConstruct
    public void init(){
        System.out.println(getClass().getSimpleName());
    }
    @GetMapping("/send")
    public String send(){
        return this.emailServiceInterface.EmailSending() + "Hello";
    }
    @GetMapping("/send2")
    public String send2(){
        return this.emailServiceInterface2.EmailSending();
    }
    @GetMapping("/send3")
    public String send3()
    {
        return this.emailServiceInterface3.EmailSending();
    }
}
