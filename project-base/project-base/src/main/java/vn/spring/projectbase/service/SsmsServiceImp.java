package vn.spring.projectbase.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SsmsServiceImp implements EmailServiceInterface{

    public SsmsServiceImp(){
        System.out.println("ConStrutor cua lop : " + getClass().getSimpleName());
    }

    @Override
    public String EmailSending() {
        String send = "SSMS send....";
        return send ;
    }
}
