package vn.spring.mvc.crud.spring_crud.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.mvc.crud.spring_crud.entity.Student;

import java.util.List;

@Repository
public class StudentImpls implements StudentRepository{
    private EntityManager entityManager ;

    @Autowired
    public StudentImpls(EntityManager entityManager){
        this.entityManager =entityManager;
    }
    @Override
    public List<Student> getAllStudent() {
         String jpql = "select s from Student s ";
        TypedQuery<Student> query= this.entityManager.createQuery(jpql,Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = this.entityManager.find(Student.class,id);
        this.entityManager.remove(student);
    }

    @Override
    @Transactional
    public void updateStudentById(int id) {
        Student student = this.entityManager.find(Student.class,id);
        this.entityManager.merge(student);
    }
}
