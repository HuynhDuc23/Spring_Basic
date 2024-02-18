package vn.spring.mvc.crud.spring_crud.dao;

import vn.spring.mvc.crud.spring_crud.entity.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> getAllStudent();
    public void saveStudent(Student student);
    public void deleteStudentById(int id);
    public void updateStudentById(int id);

}
