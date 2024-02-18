package vn.spring.onetoone.OneToOne.dao;

import vn.spring.onetoone.OneToOne.entity.Teacher;

public interface TeacherDAO {
    public void saveTeacher(Teacher teacher);
    public Teacher findTeacherById(int id);
}
