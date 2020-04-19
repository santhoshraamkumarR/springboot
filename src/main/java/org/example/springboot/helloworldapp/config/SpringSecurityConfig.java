package org.example.springboot.helloworldapp.config;



import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  extends  WebSecurityConfigurerAdapter {


//    @Autowired
//    DataSource dataSource;

    protected  void configure(HttpSecurity httpSecurity) throws  Exception {
        httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated()
//                antMatchers("/user").hasRole("USER")
//                .antMatchers("/admin").hasRole("ADMIN")
             .and().formLogin();
    }


//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

    protected  void configure(AuthenticationManagerBuilder  authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("pass")
//                .roles("USER").and().withUser("admin").password("pass")
//        .roles("ADMIN");

        //authenticationManagerBuilder.jdbcAuthentication()
        //.dataSource(dataSource);
       // .withUser(User.withUsername("user").password("user").roles("USER"))
        //.withUser(User.withUsername("admin").password("admin").roles("ADMIN"));

     authenticationManagerBuilder.ldapAuthentication().userDnPatterns("uid={0},ou=people")
             .groupSearchBase("ou=groups").contextSource()
             .url("ldap://localhost:8389/dc=springframework,dc=org")
             .and().passwordCompare()
             .passwordEncoder(new BCryptPasswordEncoder())
             .passwordAttribute("userPassword");

    }


}
