package vn.spring.onetoone.OneToOne.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.onetoone.OneToOne.entity.Course;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class CourseImpls implements CourseDAO {
    private EntityManager entityManager ;

    @Autowired
    public CourseImpls(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        this.entityManager.persist(course);
    }

    @Override
    public List<Course> findTeacherAndCoursesByCourseId(int id) {
       String jpql = "select c from Course c JOIN FETCH c.teacher where c.id=:id";
       TypedQuery<Course> query =  this.entityManager.createQuery(jpql, Course.class);
       query.setParameter("id",id);
       return query.getResultList();
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        this.entityManager.merge(course);
    }


}
