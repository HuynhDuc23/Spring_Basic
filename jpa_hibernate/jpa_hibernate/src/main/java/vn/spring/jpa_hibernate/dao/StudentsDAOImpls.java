package vn.spring.jpa_hibernate.dao;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vn.spring.jpa_hibernate.model.Students;

import java.util.List;

@Repository

// Đánh dấu để spring quản lý tôt hơn và để spring biết đây là nơi thao tác DB
public class StudentsDAOImpls implements StudentsDAOInterface{
    private EntityManager entityManager ;

    @Autowired
    public StudentsDAOImpls(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @PostConstruct
    public void init(){
        System.out.println("Khoi Tao : "+getClass().getSimpleName());
    }

    @Override
    @Transactional
    public void saveStudent(Students students) {
        this.entityManager.persist(students);
    }

    @Override
    public Students findStudentById(int id) {
        return this.entityManager.find(Students.class,id);
    }

    @Override
    public List<Students> getAllStudents() {
        // Tạo Query dưới dạng TypeQuery và Query
        String jpql = "SELECT s FROM Students s";
        TypedQuery<Students> query = this.entityManager.createQuery(jpql,Students.class);
        return query.getResultList();
    }

    @Override
    public List<Students> getAllStudentsByTen(String ten) {
        String jpql = "Select s from Students s where s.ten=:t";
        TypedQuery<Students> query =  this.entityManager.createQuery(jpql,Students.class);
        query.setParameter("t",ten);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Students student =  this.entityManager.find(Students.class,id);
        if(student==null){
            System.out.println("Vui Lòng Chon Đúng Id để Xóa");
        }
        else{
            this.entityManager.remove(student);
        }
    }

    @Override
    @Transactional
    public void updateStudent(Students student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateStudentByTen(String ten) {
        String jpql ="update Students s set s.ten=:t";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("t",ten);
        int rows  = query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteDataStudents() {
        String jpql = "delete from Students ";
        Query query =  this.entityManager.createQuery(jpql);
        int rows =  query.executeUpdate();
    }

}
