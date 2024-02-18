package vn.spring.onetoone.OneToOne.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "teach_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;
    @Column(name = "address", length = 255)
    private String address ;
    @Column(name = "salary", length = 255)
    private double salary ;
    @Column(name = "date_of_birth")
    private Date dateOfBirth ;
    @Column(name = "identification_number")
    private String IdentificationNumber ;
    @Column(name = "youtube_channel")
    private String youtubeChannel ;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "teacherDetail")
    private Teacher teacher ;

    public TeacherDetail() {
    }

    public TeacherDetail(int id, String address, double salary, Date dateOfBirth, String identificationNumber, String youtubeChannel) {
        this.id = id;
        this.address = address;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        IdentificationNumber = identificationNumber;
        this.youtubeChannel = youtubeChannel;
    }

    public TeacherDetail(String address, double salary, Date dateOfBirth, String identificationNumber, String youtubeChannel) {
        this.address = address;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        IdentificationNumber = identificationNumber;
        this.youtubeChannel = youtubeChannel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentificationNumber() {
        return IdentificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        IdentificationNumber = identificationNumber;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", dateOfBirth=" + dateOfBirth +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                '}';
    }
}
