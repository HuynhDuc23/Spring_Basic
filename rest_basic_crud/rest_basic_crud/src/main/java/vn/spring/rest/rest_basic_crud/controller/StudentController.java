package vn.spring.rest.rest_basic_crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.spring.rest.rest_basic_crud.dao.StudentDAOImpls;
import vn.spring.rest.rest_basic_crud.dao.StudentDAOInterface;
import vn.spring.rest.rest_basic_crud.dao.StudentJpaRepository;
import vn.spring.rest.rest_basic_crud.entity.Student;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentDAOInterface studentDAOInterface;
    private StudentJpaRepository studentJpaRepository ;

    @Autowired
    public StudentController(StudentDAOInterface studentDAOInterface , StudentJpaRepository studentJpaRepository) {
        this.studentDAOInterface = studentDAOInterface;
        this.studentJpaRepository =  studentJpaRepository;
    }


    @GetMapping("/findBy")
    public  List<Student>getAll(){
        // Ch ví dụ
       return  this.studentJpaRepository.findAll();
    }
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return this.studentDAOInterface.selectAllStudent();
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id) {
        Student st = this.studentDAOInterface.selectStudentById(id);
        return st;
    }
    @PostMapping("/post")
    public void insertStudent(@RequestBody Student student){
        
        this.studentDAOInterface.insertStudent(student);
    }
    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student){
        this.studentDAOInterface.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable int id){
        logger.info("Đây là logger do tôi tạo");
        this.studentDAOInterface.deleteStudentById(id);
    }
}
