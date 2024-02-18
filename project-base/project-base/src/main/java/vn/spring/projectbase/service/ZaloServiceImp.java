package vn.spring.projectbase.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZaloServiceImp implements  EmailServiceInterface{

    public ZaloServiceImp(){
        System.out.println("Constructor cua lop : "+ getClass().getSimpleName());
    }

    @Override
    public String EmailSending() {
        String send = "Send Zalo.....";
        return send ;
    }
}
