package vn.spring.onetoone.OneToOne.dao;

import vn.spring.onetoone.OneToOne.entity.Course;
import vn.spring.onetoone.OneToOne.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    public void saveTeacher(Teacher teacher);

    public void deleteTeacher(int id);

    public Teacher findTeacherById(int id);
    public Teacher findTeacherByCoursesId(int id);
    public void deleteTeacherById(int id);


}

