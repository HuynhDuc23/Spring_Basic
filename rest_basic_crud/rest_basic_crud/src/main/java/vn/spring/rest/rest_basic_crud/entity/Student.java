package vn.spring.rest.rest_basic_crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name="sinh_vien")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id ;

    @Column(name = "name", nullable = false ,length = 45)
    private String name  ;
    @Column(name = "address", nullable = false,length = 45)
    private String address ;

    @Column(name = "course" , nullable = false , length = 45)
    private String course ;

    public Student() {
    }

    public Student(int id, String name, String address, String course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.course = course;
    }

    public Student(String name, String address, String course) {
        this.name = name;
        this.address = address;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
