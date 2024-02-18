package vn.spring.jpa_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
//		scanBasePackages = {
//				"vn.spring.jpa_hibernate.application",
//				"vn.spring.jpa_hibernate.common",
//				"vn.spring.jpa_hibernate.controller",
//				"vn.spring.jpa_hibernate.dao",
//				"vn.spring.jpa_hibernate.model"
//		}
)
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

}
// Java Persistence Query Language : Sử dụng để truy vấn đối tượng
