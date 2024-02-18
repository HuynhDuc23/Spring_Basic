package vn.spring.onetoone.OneToOne.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.onetoone.OneToOne.entity.Course;
import vn.spring.onetoone.OneToOne.entity.Student;

import java.util.List;

@Repository
public class StudentImpls implements StudentDAO{
    private EntityManager entityManager ;

    @Autowired
    public StudentImpls(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findStudentById(int id) {
         return this.entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findCoursesByIdOfStudent(int id) {
        String jpql = "select c from Student c " + "JOIN FETCH c.courses where c.id=:x";
        TypedQuery<Student> query =  this.entityManager.createQuery(jpql,Student.class);
        query.setParameter("x",id);
        return query.getResultList();


    }

}
