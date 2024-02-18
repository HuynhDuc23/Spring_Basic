package vn.spring.rest.rest_basic_crud.dao;

import vn.spring.rest.rest_basic_crud.entity.Student;

import java.util.List;

public interface StudentDAOInterface {
    public Student insertStudent(Student student);
    public Student selectStudentById(int id);

    public void deleteStudentById(int id);
    public void updateStudent(Student student);

    public List<Student> selectAllStudent() ;

    public void deleteAllStudent();

    public List<Student> findStudentByName(String name);

    public void updateStudentAllByName(String name);
}
