package vn.spring.onetoone.OneToOne.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Column(name = "name_course", length = 255)
    private String nameCourse ;
    @Column(name = "start_course")
    private Date startCourse ;
    @Column(name = "end_course")
    private Date endCourse ;
    @Column(name = "description",length = 255)
    private String description ;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "teacher_id")
    private Teacher teacher ;

    @ManyToMany(cascade =
            {
                    CascadeType.DETACH ,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH ,
                    CascadeType.MERGE
            } ,fetch = FetchType.LAZY
    )
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Date getStartCourse() {
        return startCourse;
    }

    public void setStartCourse(Date startCourse) {
        this.startCourse = startCourse;
    }

    public Date getEndCourse() {
        return endCourse;
    }

    public void setEndCourse(Date endCourse) {
        this.endCourse = endCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course(int id) {
        this.id = id;
    }

    public Course() {
    }

    public Course(String nameCourse, Date startCourse, Date endCourse, String description, Teacher teacher) {
        this.nameCourse = nameCourse;
        this.startCourse = startCourse;
        this.endCourse = endCourse;
        this.description = description;
        this.teacher = teacher;
    }

    public Course(int id, String nameCourse, Date startCourse, Date endCourse, String description, Teacher teacher) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.startCourse = startCourse;
        this.endCourse = endCourse;
        this.description = description;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nameCourse='" + nameCourse + '\'' +
                ", startCourse=" + startCourse +
                ", endCourse=" + endCourse +
                ", description='" + description + '\'' +
                '}';
    }
}
