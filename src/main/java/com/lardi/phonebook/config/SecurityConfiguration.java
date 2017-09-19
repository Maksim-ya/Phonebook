package com.lardi.phonebook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Autowired
////    @Value("${security.user.password}")
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
//    @Value("spring.datasource.url")
    private DataSource dataSource;

//    @Value("${security.user.name}")
//    private String usersQuery;

//    @Value("${security.user.password}")
//    private String passwordQuery;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select  login, password,'true' as enabled from user where login=?")
                .authoritiesByUsernameQuery("select login, 'ROLE_USER' from user where login=?");
//                .passwordEncoder(passwordQuery);
//                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login", "/registration").permitAll()
                .anyRequest().authenticated()
                // .and().csrf().disable().formLogin()
                .and()
                .formLogin()
                .loginPage("/login")
                // .failureUrl("/login?error=true")
                .defaultSuccessUrl("/index")
                .usernameParameter("login")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll();
//
    }


//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password");
//    }

}
