package vn.spring.jpa_hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name="sinhvien")
public class Students {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "ho_dem", length = 45,nullable = false)
    private String hoDem ;
    @Column(name = "ten",length = 45,nullable = false)
    private String ten;

    @Column(name = "email",length = 45,nullable = false)
    private String email ;

    public Students() {
    }

    public Students(String hoDem, String ten, String email) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
