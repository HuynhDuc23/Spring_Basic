package vn.spring.onetoone.OneToOne.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import vn.spring.onetoone.OneToOne.entity.Teacher;

@Repository
public class TeacherImpls implements TeacherDAO {
    private EntityManager entityManager ;
    @Autowired
    public TeacherImpls(EntityManager entityManager) {
        this.entityManager =entityManager ;
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        this.entityManager.persist(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher = this.entityManager.find(Teacher.class,id);
        if(teacher==null){
            System.out.println("Cant Not Find By Id");
        }
        return teacher ;
    }
}
