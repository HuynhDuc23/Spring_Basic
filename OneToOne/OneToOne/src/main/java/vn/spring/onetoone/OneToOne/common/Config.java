package vn.spring.onetoone.OneToOne.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.spring.onetoone.OneToOne.dao.CourseDAO;
import vn.spring.onetoone.OneToOne.dao.StudentDAO;
import vn.spring.onetoone.OneToOne.dao.TeacherDAO;
import vn.spring.onetoone.OneToOne.entity.Course;
import vn.spring.onetoone.OneToOne.entity.Student;
import vn.spring.onetoone.OneToOne.entity.Teacher;
import vn.spring.onetoone.OneToOne.entity.TeacherDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class Config {
    @Bean
    @Autowired
    public CommandLineRunner getCommandLineRunner(TeacherDAO teacherDAO, CourseDAO courseDAO, StudentDAO studentDAO)
    {
        return runner -> {
              //  createTeacher(teacherDAO);
             //   createCourse(courseDAO,teacherDAO);
            // deleteTeacher(teacherDAO,28);
           //  createStudentAndAddCourses(studentDAO);
          //  getStudents(studentDAO,1,courseDAO);
           //   findTeacher(teacherDAO,26);
            findTeacherAndCourses(teacherDAO,courseDAO,4);

        };
    }

    private void findTeacherAndCourses(TeacherDAO teacherDAO, CourseDAO courseDAO, int id) {
        List<Course> courses = courseDAO.findTeacherAndCoursesByCourseId(id);
        System.out.println(courses);
        for (Course course:courses) {
            System.out.println(course.getTeacher());
            course.setTeacher(null);
            courseDAO.updateCourse(course);
            System.out.println(course.getTeacher());
        }
        teacherDAO.deleteTeacherById(26);


    }

    private void findTeacher(TeacherDAO teacherDAO, int i) {
        Teacher teacher =  teacherDAO.findTeacherByCoursesId(i) ;
        System.out.println(teacher);
        System.out.println(teacher.getTeacherDetail());
        List<Course> courses = teacher.getCourses();
        for(Course course :courses){
            System.out.println(course);
        }
    }

    private void getStudents(StudentDAO studentDAO, int id , CourseDAO courseDAO) {
        Student student = studentDAO.findStudentById(id);
        System.out.println(student.toString());
        List<Student> st = studentDAO.findCoursesByIdOfStudent(id);
        for(int i = 0 ; i < st.size() ;i++){
            System.out.println(st.get(i).getCourses());
            // Để join nhiều bảng bảng trong jpql đối tượng ta dùng JOIN FETCH
        }

    }

    private void createStudentAndAddCourses(StudentDAO studentDAO) {
        Student st =  new Student();
        st.setFirstName("Adrew");
        st.setLastName("Knew");

        Course course =  new Course();
        course.setNameCourse("Lap Trinh Mang");
        course.setDescription("Ok");

        Course course2 =  new Course();
        course2.setNameCourse("Lap Trinh Mang 2");
        course2.setDescription("Ok 2");

        st.addCourseIntoStudent(course);
        st.addCourseIntoStudent(course2);

        Teacher teacher =  new Teacher();

        teacher.setFirstName("IT1");

        course2.setTeacher(teacher);
        course.setTeacher(teacher);

        studentDAO.saveStudent(st);
    }

    private void deleteTeacher(TeacherDAO teacherDAO , int id) {
         teacherDAO.deleteTeacher(id);
    }

    private void createCourse(CourseDAO courseDAO, TeacherDAO teacherDAO) {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Trần Anh Đông");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setAddress("Quảng Ngãi");

        teacher.setTeacherDetail(teacherDetail);

        Course c1 =  new Course();
        c1.setTeacher(teacher);
        c1.setNameCourse("Hibernate");

        Course c2 =  new Course();
        c2.setNameCourse("Rs");
        c2.setTeacher(teacher);

        teacher.addCourse(c1);
        teacher.addCourse(c2);

        teacherDAO.saveTeacher(teacher);



    }

    public void createTeacher(TeacherDAO teacherDAO){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Trần Vũ Huỳnh Đức 2");
        teacher.setLastName("Lùm 2");
        teacher.setGender(true);


        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setAddress("Bình Thới 2");

        teacher.setTeacherDetail(teacherDetail);

        teacherDAO.saveTeacher(teacher);
        System.out.println("Done");
        System.out.println(teacher);
        System.out.println("Done");
        //fetch  type eager (defalut)
        System.out.println(teacher.getTeacherDetail());
    }
}
