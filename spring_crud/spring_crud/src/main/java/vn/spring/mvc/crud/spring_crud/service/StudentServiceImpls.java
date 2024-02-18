package vn.spring.mvc.crud.spring_crud.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.spring.mvc.crud.spring_crud.dao.StudentRepository;
import vn.spring.mvc.crud.spring_crud.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpls implements StudentService{
    private StudentRepository studentRepository ;
    @Autowired
    public StudentServiceImpls(StudentRepository studentRepository){
        this.studentRepository = studentRepository ;
    }
    @Override
    public List<Student> getAllListStudents() {
        return this.studentRepository.getAllStudent();
    }

    @Override
    @Transactional
    public void save(Student student) {
         this.studentRepository.saveStudent(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
         this.studentRepository.deleteStudentById(id);
    }

    @Override
    @Transactional
    public void update(int id) {
         this.studentRepository.updateStudentById(id);
    }
}
