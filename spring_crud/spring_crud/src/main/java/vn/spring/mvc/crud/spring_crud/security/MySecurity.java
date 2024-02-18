package vn.spring.mvc.crud.spring_crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurity {
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select us,ps,enable from accounts where us=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select us , rs from auths where us=?");
        return jdbcUserDetailsManager ;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                confi->confi.requestMatchers(HttpMethod.GET,"/student/**")
                        .hasAnyRole("TEACHER","ADMIN","MANAGER")
                        .anyRequest().permitAll()

        );
        http.formLogin(
                confi->confi.loginPage("/showpage1")
                        .loginProcessingUrl("/authenticatedTheUser")
                        .defaultSuccessUrl("/student/list")
                        .permitAll()
        );
        http.logout(
                confi->confi
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/showpage1")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
        );
        http.exceptionHandling(
                confi->confi.accessDeniedPage("/403")

        );
         http.httpBasic(Customizer.withDefaults());
         return http.build();
    }

}
