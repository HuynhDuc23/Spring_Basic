package vn.spring.onetoone.OneToOne.dao;

import vn.spring.onetoone.OneToOne.entity.Course;
import vn.spring.onetoone.OneToOne.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void saveStudent(Student student);
    public Student findStudentById(int id);

    public List<Student> findCoursesByIdOfStudent(int id);

}
