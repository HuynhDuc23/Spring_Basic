package vn.spring.mvc.crud.spring_crud.service;

import org.springframework.stereotype.Service;
import vn.spring.mvc.crud.spring_crud.entity.Student;

import java.util.List;


public interface StudentService {
    public List<Student> getAllListStudents();
    public void save(Student student);
    public void delete(int id);
    public void update(int id);
}
