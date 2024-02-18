package vn.spring.projectbase.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImp implements EmailServiceInterface{
    @PostConstruct
     public void init(){
         System.out.println("Khởi Tạo");
     }
    public EmailServiceImp()
    {
        System.out.println("Constructor cua lop :" + getClass().getSimpleName());
    }
    @Override
    public String EmailSending() {
        String message = "Email Sending...";
        return message ;
    }
    @PreDestroy
    public void cleanUp(){
        System.out.println("Hủy");
    }
}
