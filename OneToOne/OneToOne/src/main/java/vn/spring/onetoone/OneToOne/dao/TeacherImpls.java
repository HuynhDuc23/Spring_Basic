package vn.spring.onetoone.OneToOne.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.spring.onetoone.OneToOne.entity.Course;
import vn.spring.onetoone.OneToOne.entity.Teacher;

import java.util.List;

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
    @Transactional
    public void deleteTeacher(int id) {
        Teacher teacher =  this.findTeacherById(id);
        this.entityManager.remove(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return this.entityManager.find(Teacher.class,id);
    }

    @Override
    public Teacher findTeacherByCoursesId(int id) {
         String jpql ="select t from Teacher t " + "JOIN FETCH  t.courses where t.id=:id";
        TypedQuery<Teacher> query = this.entityManager.createQuery(jpql,Teacher.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteTeacherById(int id) {
        this.entityManager.remove(this.entityManager.find(Teacher.class,id));
    }


    // Join : Trả về dữ liệu cả bảng chinh : Teacher JOIN Course -> Trả về dữ liệu Teacher
    // Join Fetch -> Trả về Teacher và Course

}
