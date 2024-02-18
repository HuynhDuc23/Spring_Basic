package vn.spring.jpa_hibernate.dao;

import vn.spring.jpa_hibernate.model.Students;

import java.util.List;

public interface StudentsDAOInterface {
    public void saveStudent(Students students);
    public Students findStudentById(int id);
    public List<Students> getAllStudents();
    public List<Students> getAllStudentsByTen(String ten);
    public void deleteStudentById(int id );
    public void updateStudent(Students student);
    public void updateStudentByTen(String ten);
    public void deleteDataStudents();

}
