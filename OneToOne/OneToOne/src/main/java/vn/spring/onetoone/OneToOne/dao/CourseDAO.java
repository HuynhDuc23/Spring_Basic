package vn.spring.onetoone.OneToOne.dao;

import vn.spring.onetoone.OneToOne.entity.Course;

import java.util.List;

public interface CourseDAO {
    public void saveCourse(Course course);
    public List<Course> findTeacherAndCoursesByCourseId(int id);
    public void updateCourse(Course course);

}
