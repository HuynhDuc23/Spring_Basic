package vn.spring.jpa_hibernate.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.spring.jpa_hibernate.dao.StudentsDAOInterface;
import vn.spring.jpa_hibernate.model.Students;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getCommandLineRunner(StudentsDAOInterface studentsDAOInterface)
    {
        Scanner sc = new Scanner(System.in);
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Xin Chào Vui Lòng Nhập Thông Tin");
                printMenu();
                int choose = 0 ;
                choose = sc.nextInt();
                sc.nextLine() ;
                while(true){
                    if(choose==1)
                    {
                      themSinhVien(studentsDAOInterface);
                    }
                    else if(choose==2){
                        timKiemSinhVien(studentsDAOInterface);
                        break;
                    }
                    else if(choose==3){
                        inDanhSachSinhVien(studentsDAOInterface);
                        break ;
                    }
                    else if (choose==4){
                        timKiemDanhSachSinhVienTheoTen(studentsDAOInterface);
                        break;
                    }else if(choose==5){
                        xoaSinhVienTheoId(studentsDAOInterface);
                        break ;
                    }
                    else if(choose==6){
                        capNhatMotSinhVien(studentsDAOInterface);
                        break;
                    }
                    else if(choose==7){
                        capNhatSinhVienTatCaTheoTen(studentsDAOInterface);
                        break;
                    }else if (choose==8){
                        xoaTatCaDuLieu(studentsDAOInterface);
                        break;
                    }
                }
            }
        };
    }
    public void printMenu(){
        System.out.println("----------------");
        System.out.println("Vui Lòng Chọn Mục : ");
        System.out.println("1: Thêm Một Sinh viên");
        System.out.println("2: Tim Kiếm  Một Sinh Viên");
        System.out.println("3: Danh Sách Sinh Viên");
        System.out.println("4: Tìm Kiếm Sinh Viên Theo Ten ");
        System.out.println("5 : Xóa Một Sinh Viên Bởi Id");
        System.out.println("6 : Cập Nhật 1 Sinh Viên");
        System.out.println("7 : Cập Nhật Theo ten : ");
        System.out.println("8: Xóa dữ liệu trong bảng : ");

    }

    public void themSinhVien(StudentsDAOInterface studentsDAOInterface){
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Vui Lòng Nhập Họ Đệm \n");
        String hoDem = scanner.nextLine();
        System.out.println("Vui Lòng Nhập Tên : \n");
        String ten = scanner.nextLine();
        System.out.println("Vui Lòng Nhập Email : \n");
        String email = scanner.nextLine();
        Students st = new Students();
        st.setHoDem(hoDem);
        st.setTen(ten);
        st.setEmail(email);
        studentsDAOInterface.saveStudent(st);
    }
    public void timKiemSinhVien(StudentsDAOInterface studentsDAOInterface){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui Lòng Nhập Mã Id : ");
        int id = sc.nextInt();
        Students students =  studentsDAOInterface.findStudentById(id);
        if(students==null){
            System.out.println("Không Tìm Thấy Sinh Viên");
        }else{
            System.out.println(students.toString());
        }
    }
    public void inDanhSachSinhVien(StudentsDAOInterface studentsDAOInterface){
        List<Students> listStudent =  studentsDAOInterface.getAllStudents();
        if(listStudent.size()==0){
            System.out.println("Danh Sach Rong");
        }else{
            for(int i = 0 ; i < listStudent.size() ;i++){
                System.out.println(listStudent.get(i).toString());
            }
        }
    }
    public void timKiemDanhSachSinhVienTheoTen(StudentsDAOInterface studentsDAOInterface){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Vui Lòng Nhập Tên Cần Tìm Kiếm : \n");
        String ten = sc.nextLine();
        List<Students> listStudentByTen = studentsDAOInterface.getAllStudentsByTen(ten);
        if(listStudentByTen.size()==0){
            System.out.println("Không Tìm Thấy Sinh Viên");
        }
        else {
            for(Students student : listStudentByTen){
                System.out.println(student.toString());
            }
        }
    }
    public void xoaSinhVienTheoId(StudentsDAOInterface studentsDAOInterface){
        System.out.println("Vui Lòng Chọn Id Muốn Xóa");
        Scanner sc =  new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        Students student = studentsDAOInterface.findStudentById(id);
        if(student==null){
            System.out.println("Không Có Sinh Viên với Id Này");
        }
        else{
            studentsDAOInterface.deleteStudentById(id);
        }

    }
    public void capNhatMotSinhVien(StudentsDAOInterface studentsDAOInterface){
        System.out.println("Vui Lòng Chọn Id để cập nhật");
        Scanner sc =  new Scanner(System.in);
        int id =  sc.nextInt();
        sc.nextLine();
        Students students =  studentsDAOInterface.findStudentById(id);
        if(students==null){
            System.out.println("Không tìm thấy id để cập nhật sinh viên");
        }
        else {
            System.out.println("Vui Lòng Cập Nhật Lại Thông Tin Sinh Viên :"+id);
            System.out.println("Ho Dem :");
            String hoDem = sc.nextLine();

            System.out.println("Ten : ");
            String ten =sc.nextLine();
            System.out.println("Email : ");
            String email =sc.nextLine();

            students.setHoDem(hoDem);
            students.setTen(ten);
            students.setEmail(email);
            studentsDAOInterface.updateStudent(students);
        }
    }
    public void capNhatSinhVienTatCaTheoTen(StudentsDAOInterface studentsDAOInterface){
        System.out.println("Vui Lòng Chọn Tên Để Cập Nhật tất cả :");
        Scanner sc = new Scanner(System.in);
        String ten =  sc.nextLine();
        studentsDAOInterface.updateStudentByTen(ten);

    }
    public void  xoaTatCaDuLieu( StudentsDAOInterface studentsDAOInterface){
        studentsDAOInterface.deleteDataStudents();
    }


}
