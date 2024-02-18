package vn.spring.projectbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.spring.projectbase.libary.CaculatorInterface;

@RestController
@RequestMapping("/caculator")
public class ControllerCaculator {
    private CaculatorInterface caculatorInterface ;
    @Autowired
    public ControllerCaculator(@Qualifier("getCaculatorInterface") CaculatorInterface caculatorInterface){
        this.caculatorInterface =  caculatorInterface ;
    }
    @GetMapping("/cong")
    public String congHaiSo(@RequestParam("value") int a , @RequestParam("value2") int b)
    {
        return "Cong = "  + this.caculatorInterface.congHaiSo(a,b);
    }
    public String truHaiSo(@RequestParam("value") int a , @RequestParam("value2") int b){
        return "Tru = " + this.caculatorInterface.truHaiSo(a,b);
    }
}
