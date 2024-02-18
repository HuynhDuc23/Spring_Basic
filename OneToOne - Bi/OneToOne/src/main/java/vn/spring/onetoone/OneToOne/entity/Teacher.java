package vn.spring.onetoone.OneToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;
    @Column(name = "first_name",length = 255)
    private String firstName ;
    @Column(name = "last_name",length = 255)
    private String lastName ;
    @Column(name = "gender",length = 255)
    private boolean gender ;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, boolean gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Teacher(String firstName, String lastName, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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

    public boolean isGender() {
        return gender;
    }
    // Uni directional
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_detail_id")
    private TeacherDetail teacherDetail ;

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public Teacher(int id, String firstName, String lastName, boolean gender, TeacherDetail teacherDetail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.teacherDetail = teacherDetail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", teacherDetail=" + teacherDetail +
                '}';
    }
}
