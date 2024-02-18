package vn.spring.onetoone.OneToOne.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.onetoone.OneToOne.entity.TeacherDetail;

@Repository
public class TeacherDetailImpls implements TeacherDetailDAO{
    private EntityManager entityManager ;

    @Autowired
    public TeacherDetailImpls(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveTeacherDetail(TeacherDetail teacherDetail) {
        this.entityManager.persist(teacherDetail);
    }

    @Override
    public TeacherDetail findTeacherDetailById(int id) {
        TeacherDetail teacherDetail = this.entityManager.find(TeacherDetail.class,id);
        if(teacherDetail==null){
            System.out.println("Error");
            return null ;
        }
        return teacherDetail ;
    }
}
