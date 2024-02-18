package vn.spring.projectbase.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {
    @Value("${course.user}")
    private String user ;
    @Value("${course.info}")
    private String infor ;

    public String getUser()
    {
        return user ;
    }
    public String getInfor()
    {
        return infor ;
    }
    @GetMapping("/")
    public String getHello()
    {
        return "Hello World !" ;
    }
    @GetMapping("/infor")
    public String  getAllInformationInApplication()
    {
        String informationOfProjects =  getUser() + " " + getInfor() ;
        return informationOfProjects + " Huỳnh Đức 76c1" ;
    }

    // Spring Boot Starter Dependency
    // Tạo ra sự đông trong dự án về phiên bản và tránh xung đột thư viện

    // kiểm tra thông tin và tương tác với Spring project thông qua actuator

    // 3.9 :kết hợp actuator và security dependency : sau khi thêm dependency security và cấu hình
    // trong application properties thì user và pass được người viết cấu hình tùy thích
    // Actuator cho phép ta theo dõi, giám sát ứng dụng, thu thập số liệu, lưu lượng truy cập hay trạng thái cơ sở dữ liệu, v.v.

    // 4 : IOC và DI : Inversion Of Controller : Đảo ngược điều khiển (Spring Container)
    // Spring Framework có hai loại IoC Container chính: BeanFactory ,ApplicationContext

    // Các loại Dependency Ịnecjtion
    // 5.1 Components and Injections
    // 5.2 Quét components trong spring
    // Chú ý khi sử dụng @Qualifier("") : Giống tên với Class , nhưng viết thường chữ cái đầu...
    // 5.6 : Primary : nó sẽ ưu tiên 1 bean nào đó được ưu tiên khi có nhiều class imple 1 interface @Primary
    // Lazy : đụng tới phần nào sẽ load đến đấy -> có ưu và nhược diểm :
    // Nếu sử dụng @Quanlifier và @Primary không có tác dụng ...
    // Khi Cấu hình trong applicationp.properties thì tất cả các comppnet sẽ là lazy , gọi đến enpoint thì nó mới tạo đối tượng và thêm vào

    // Bean Scope : Phạm Vi của Bean...

    // Vòng đời của Bean Life Cycle ...

    // Khi Sử dụng Prototype -> Spring không gọi phương thức Destroy
    // Khi sử dụng Prototype -> không cần khai báo @Lazy
    // Có thể khỏi tạo thoải mái PostContruct và PreDestroy ...

    // 5.14 cấu Hình Bean Với Java code  : Vì ngoài những đánh dấu @Component thì còn có những
    // class được xây dựng sẵn , chúng ta không thể đánh dấu @Compenent

    // 6.3 Thực hành tạo dự án Hibernate và Jpa trong Spring boot
    // Cấu hình dự án Spring boot có sử dụng Hibernate
    // Trong spingboot , hibernate là mặc định khi bạn muốn dùng JPA...

}
