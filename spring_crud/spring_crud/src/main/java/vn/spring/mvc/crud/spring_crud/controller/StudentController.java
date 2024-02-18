package vn.spring.mvc.crud.spring_crud.controller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.spring.mvc.crud.spring_crud.dao.StudentRepository;
import vn.spring.mvc.crud.spring_crud.entity.Student;
import vn.spring.mvc.crud.spring_crud.service.StudentService;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    private StudentService studentService ;
    @Autowired
    private EntityManager entityManager ;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService ;
    }
    @GetMapping("/list")
    public String getAllStudents(Model model){
        List<Student> lists = this.studentService.getAllListStudents();
        model.addAttribute("lists",lists);
        return "/student/students";
    }
    @GetMapping("/create")
    public String create (Model model){
        Student student =  new Student();
        model.addAttribute("student",student);
        return "/student/form";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student){
        this.studentService.save(student);
        // Chuyển hướng trang
        return "redirect:/student/list";
    }
    @GetMapping("/update")
    public String updateStudent(@RequestParam("id") int id , Model model){
        List<Student> lists = this.studentService.getAllListStudents();
        Student student = new Student() ;
        for(Student st : lists){
           if(id==st.getId()){
               student.setId(id);
               student.setAddress(st.getAddress());
               student.setFirstName(st.getFirstName());
               student.setLastName(st.getLastName());
               break;
           }
        }
        model.addAttribute("student",student);
        return "/student/studentById";
    }
    @PostMapping("/update-student")
    @Transactional
    public String update_student(@ModelAttribute("student") Student student){
        this.entityManager.merge(student);
        return "redirect:/student/list";
    }
    @GetMapping("/delete")
    @Transactional
    public String deleteStudent(@RequestParam("id") int id){
        Student student = this.entityManager.find(Student.class,id);
        this.entityManager.remove(student);
        return "redirect:/student/list";

    }

}
