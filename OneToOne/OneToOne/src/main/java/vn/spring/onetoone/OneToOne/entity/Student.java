package vn.spring.onetoone.OneToOne.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;
    @Column(name = "first_name",length = 255)
    private String firstName ;
    @Column(name = "last_name",length = 255)
    private String lastName ;
    @Column(name = "address",length = 255)
    private String address ;

    @ManyToMany(cascade = {
            CascadeType.DETACH ,
            CascadeType.MERGE ,
            CascadeType.REFRESH ,
            CascadeType.PERSIST
    },fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Course> courses ;

    public Student() {
    }

    public Student(String firstName, String lastName, String address, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.courses = courses;
    }

    public Student(int id, String firstName, String lastName, String address, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public List<Course> addCourseIntoStudent(Course course){
        if(this.courses==null){
            this.courses = new ArrayList<>();
        }
        this.courses.add(course);
        return this.courses;
    }

}
