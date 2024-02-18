package vn.spring.rest.rest_basic_crud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import vn.spring.rest.rest_basic_crud.entity.Student;
import vn.spring.rest.rest_basic_crud.global_exception.StudentException;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentDAOImpls implements StudentDAOInterface{

    private EntityManager entityManager ;
    @Autowired
    public StudentDAOImpls (EntityManager entityManager){
        this.entityManager = entityManager ;
    }
    @Override
    @Transactional
    public Student insertStudent(Student student) {

      int  id = 0 ;
       student.setId(id);
       this.entityManager.persist(student);
        return student;
    }

    @Override
    public Student selectStudentById(int id) {
         Student student = new Student() ;
         student = this.entityManager.find(Student.class,id);
         if(student==null){
             throw  new StudentException("Loi Khong Tim Thay Sinh Vien");
         }
         return student ;

    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        String jpql ="delete from Student s where s.id=:id";
        Query query =  this.entityManager.createQuery(jpql);
        query.setParameter("id",id);
        int rows = query.executeUpdate();
        if(rows>0){
            System.out.println("Số dòng đã bị xóa" + rows);
        }
        else{
            System.out.println("Không có : "+id +"Này trong table");
        }
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
          List<Student> listStudent = this.selectAllStudent();
          boolean checkId  = false ;
          for(Student st : listStudent)
          {
              if(st.getId()==student.getId())
              {
                  st.setName(student.getName());
                  st.setAddress(student.getAddress());
                  st.setCourse(student.getCourse());
                  this.entityManager.merge(st);
                  checkId = true ;
                  break;
              }
          }
          if(checkId){
              System.out.println("Sucess!");
          }
          else{
              System.out.println("error");
          }


    }

    @Override
    public List<Student> selectAllStudent() {
        String jpql ="select s from Student s";
        TypedQuery<Student> query = this.entityManager.createQuery(jpql,Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteAllStudent() {
          String jpql = "delete from Student";
          Query query =  this.entityManager.createQuery(jpql);
          int rows = query.executeUpdate() ;
          if(rows > 0){
              System.out.println("Sucess!");
          }
          else{
              System.out.println("Error");
          }
    }

    @Override
    public List<Student> findStudentByName(String name) {
       String jpql = "select s from Student s where s.name =:name";
       TypedQuery<Student> query = this.entityManager.createQuery(jpql,Student.class);
       query.setParameter("name",name);
       return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudentAllByName(String name) {
        String jpql ="update Student s set s.name=:name";
        Query query = this.entityManager.createQuery(jpql);
        int rows =query.executeUpdate();
        if(rows>0){
            System.out.println("Cập Nhật Thành Công");
        }
        else{
            System.out.println("Cập Nhật Thất Bại");
        }
    }
}
