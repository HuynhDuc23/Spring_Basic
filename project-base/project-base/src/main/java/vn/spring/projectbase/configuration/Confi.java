package vn.spring.projectbase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.spring.projectbase.libary.Caculator;
import vn.spring.projectbase.libary.CaculatorAdvan;
import vn.spring.projectbase.libary.CaculatorInterface;

@Configuration
public class Confi {
     @Bean
     public CaculatorInterface getCaculatorInterface()
     {
         return new Caculator();
     }
     @Bean
     public CaculatorInterface getCaculatorInterfaceAd(){
         return new CaculatorAdvan();
     }
}
