package vn.spring.rest.rest_basic_crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.spring.rest.rest_basic_crud.entity.Student;
@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Integer> {

}
// Spring Data Jpa : Khi 1 Interface kế thừa Interface JpaRepository cần xác dịnh tên class
// và khóa chính , khi chạy ứng dụng Spring data jpa sẽ tạo 1 implementation để hiện thực
// tất cả các phương thức cuủa JpaRepository ... sau đó dùng @Autowired
// có khả năng mở rộng dùng @Query , hoặc viết theo quy định spring data jpa