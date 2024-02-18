package vn.spring.rest.rest_basic_crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MyConfigure {

     // config enable
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager =  new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select us , ps , enable from accounts where us =?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select us , rs from auths where us =?");
        return jdbcUserDetailsManager ;
    }



//    @Bean
//    @Autowired
//    // Data source sinh ra khi kết nối thành công database -> chỉ cần tim vào...
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(dataSource);
//        return jdbcUserDetailsManager;
//    }
    // Chú ý nếu không cấu hình thì mặc định cần phải tạo bảng user và authorities như của spring
    // thì nó mới hoặt động ... users : username , password , enable ...
    // Pass : role , user...
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        UserDetails user1 = User.withUsername("user1")
//                .password("{noop}12345")
//                .roles("teacher").build();
//        UserDetails user2 = User.withUsername("user2")
//                .password("{noop}123456").roles("manager").build();
//
//        UserDetails user3 = User.withUsername("user3").password("{noop}1234567").roles("admin").build();
//
//        // {noop} : bắt buộc có để cho spring hiểu đây là loại mật khẩu dạng thô , chứ không phải encode
//        return new InMemoryUserDetailsManager(user1, user2, user3);
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                config -> config.requestMatchers(HttpMethod.GET, "/api/all")
                        .hasRole("TEACHER")
                        .anyRequest().authenticated()
        );
        http.httpBasic(Customizer.withDefaults());
        // Bắt buộc có mới cấu hình chạy được
        http.csrf(csrf -> csrf.disable());
        // Trong rest API không cần thiết
        return http.build();
        // http.build() : Trẩ về SecurityFilterChain
    }

}

