package vn.spring.projectbase.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		// scan the entire project
		// lưu ý nên quét những phần nào cần dùng đến , nếu quét hết đối với dự án lớn sẽ chậm
		scanBasePackages = {
//				"vn.spring.projectbase.application",
//				"vn.spring.projectbase.controller",
//				"vn.spring.projectbase.service"
				"vn.spring.projectbase"
		}
)
public class ProjectBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBaseApplication.class, args);
	}

}
