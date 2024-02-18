package vn.spring.rest.rest_basic.model;

public class SinhVien {
    private int id ;
    private String name ;
    private String diaChi ;
    private String khoaHoc ;

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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public SinhVien(int id, String name, String diaChi, String khoaHoc) {
        this.id = id;
        this.name = name;
        this.diaChi = diaChi;
        this.khoaHoc = khoaHoc;
    }

    public SinhVien(String name, String diaChi, String khoaHoc) {
        this.name = name;
        this.diaChi = diaChi;
        this.khoaHoc = khoaHoc;
    }

    public SinhVien() {
    }
}
