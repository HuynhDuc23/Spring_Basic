package vn.spring.rest.rest_basic_crud.aspect;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vn.spring.rest.rest_basic_crud.entity.Student;

@Aspect
// AOP
// AOP : Giúp tách các phàn không chính trị ra 1 pakage : giúp ghi log , theo dõi , báo lỗi , tính thời gian
// Ví dụ : Trong thực tế khi thực hiện giao dịch chuyển tiền : Ngân hàng cần ghi log Lại Quá trình
// đăng nhập , thực hiện bước nào, lần đăng nhập cuois cùng , giúp quản lý dễ dàng
// Một số advice
@Component
public class LoggingAspect {

      private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
//    @Before("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.insertStudent(..))")
//    public void printBeforeSave(){
//        System.out.println("Kiểm Tra Trước Khi Lưu");
//    }
//
//    @After("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.insertStudent(..))")
//    public void printAffterSave(){
//        System.out.println("Bạn vừa Lưu Thành Công");
//    }
//    @Around("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.insertStudent(..))")
//    public void printAround(){
//        System.out.println("OK");
//    }
//    @AfterReturning("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.insertStudent(..))")
//    public void printAround(){
//        System.out.println("OK");
//    }
    @AfterReturning("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.deleteStudentById(..))")
    public void printAfterDeleteById(){
        System.out.println("Check By Id");
    }
    // Nói cách khác, @AfterReturning không quan trọng giá trị trả về của phương thức. Nó chỉ quan trọng là phương thức đã hoàn thành mà không gặp lỗi.
//    @After("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.deleteStudentById(..))")
//    public void printAfter(){
//        System.out.println("Thành Công");
//    }
    // After , Before: không quan tâm phương thức nó chạy xóa được hay không ... nó luôn chạy
    // Con Affter return : nó quan tâm chạy được hay không nếu chạy được nó chạy luôn Advice còn không thì nó
    // Không chạy phương thức trong advice
    @AfterThrowing("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.selectStudentById(..))")
    public void printError(){
        System.out.println("Lỗi");
    }
    @After("execution(* vn.spring.rest.rest_basic_crud.controller.StudentController.insertStudent(..))")
    public void logAfterInsertData(){
        logger.info("Data insert Sucess By Duc!");
    }
}
