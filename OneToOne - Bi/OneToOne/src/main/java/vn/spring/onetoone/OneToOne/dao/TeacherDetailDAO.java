package vn.spring.onetoone.OneToOne.dao;


import vn.spring.onetoone.OneToOne.entity.TeacherDetail;

public interface TeacherDetailDAO {
    public void saveTeacherDetail(TeacherDetail teacherDetail);
    public TeacherDetail findTeacherDetailById(int id);
}
