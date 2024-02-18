package vn.spring.onetoone.OneToOne.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.spring.onetoone.OneToOne.dao.TeacherDAO;
import vn.spring.onetoone.OneToOne.dao.TeacherDetailDAO;
import vn.spring.onetoone.OneToOne.entity.Teacher;
import vn.spring.onetoone.OneToOne.entity.TeacherDetail;

import java.util.ArrayList;

@Configuration
public class Config {
    @Bean
    @Autowired
    public CommandLineRunner getCommandLineRunner(TeacherDAO teacherDAO , TeacherDetailDAO teacherDetailDAO)
    {
        return runner -> {
          //  createTeacher(teacherDAO);
          //  createTeacherDetail(teacherDetailDAO);
              findTeacher(teacherDetailDAO,teacherDAO,25);
        };
    }

    private void findTeacher(TeacherDetailDAO teacherDetailDAO,TeacherDAO teacherDAO, int id) {
         Teacher teacher =   teacherDAO.findTeacherById(id);
         TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(id);

         Teacher teachNew = new Teacher();
         teachNew.setFirstName(teacher.getFirstName());
         teachNew.setLastName(teacher.getLastName());
         teachNew.setId(teacher.getId());
         teachNew.setTeacherDetail(teacherDetail);


         ArrayList<Teacher> list = new ArrayList<>();

        list.add(teachNew);
        System.out.println(list.get(0));
    }

    private void createTeacherDetail(TeacherDetailDAO teacherDetailDAO) {


        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setAddress("Bình Thới 911");


        Teacher teacher = new Teacher();
        teacher.setFirstName("Trần Vũ Huỳnh Đức 911");
        teacher.setLastName("Lùm 911");
        teacher.setGender(true);
        teacher.setTeacherDetail(teacherDetail);

        teacherDetail.setTeacher(teacher);

        // save teacherDetail
        teacherDetailDAO.saveTeacherDetail(teacherDetail);

        // print consolog
        System.out.println("Print");
        // System.out.println(teacherDetail.getTeacher());
        // System.out.println(teacherDetail);
        System.out.println(teacher);



    }

    public void createTeacher(TeacherDAO teacherDAO){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Trần Vũ Huỳnh Đức 3");
        teacher.setLastName("Lùm 3");
        teacher.setGender(true);


        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setAddress("Bình Thới 3");

        teacher.setTeacherDetail(teacherDetail);

        teacherDAO.saveTeacher(teacher);
        System.out.println("Done");
        System.out.println(teacher);
        System.out.println("Done");
        //fetch  type eager (defalut)
        System.out.println(teacher.getTeacherDetail());
    }
}
