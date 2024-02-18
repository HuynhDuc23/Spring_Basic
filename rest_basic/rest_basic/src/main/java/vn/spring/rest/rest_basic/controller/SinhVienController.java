package vn.spring.rest.rest_basic.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import vn.spring.rest.rest_basic.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {
    private List<SinhVien> list ;
    @PostConstruct
    public List<SinhVien> createSinhVien(){
        list =  new ArrayList<>();
        list.add(new SinhVien(1,"HuynhDuc","A","Tin"));
        list.add(new SinhVien(2,"HuynhDuc1","A","Tin"));
        list.add(new SinhVien(3,"HuynhDuc2","A","Tin"));
        list.add(new SinhVien(4,"HuynhDuc3","A","Tin"));
        list.add(new SinhVien(5,"HuynhDuc4","A","Tin"));
        return list ;
    }
    @GetMapping("/")
    public List<SinhVien> getAllSinhVien(){
        return this.list ;
    }
    @GetMapping("/{id}")
    public SinhVien findSinhVienById(@PathVariable int id){
        for(int i = 0 ; i <this.list.size();i++){
            if(id == this.list.get(i).getId()){
                return this.list.get(i);
            }
        }
        return null ;
    }
    @GetMapping("/index/{index}")
    public SinhVien getIndex(@PathVariable int index){
        return this.list.get(index);
    }
    @PostMapping("/them")
    public void insert(@RequestBody SinhVien st){
        this.list.add(st);
    }
    @DeleteMapping("/xoa/{id}")
    public boolean deleteById(@PathVariable int id){
        for(int i = 0 ; i < this.list.size();i++){
            if(id==this.list.get(i).getId()){
              boolean t = this.list.remove(this.list.get(i));
              return t ;
            }
        }
        return false ;
    }
}
