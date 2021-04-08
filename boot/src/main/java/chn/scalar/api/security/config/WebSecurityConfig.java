package chn.scalar.api.security.config;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF (cross site request forgery)
        http.csrf().disable();

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests()//
                .antMatchers("/usr/signup").permitAll()//
                .antMatchers("/usr/signin").permitAll()//
                .antMatchers("/usr/find/{name}").permitAll()//
                .antMatchers("/usr/all").permitAll()//
                .antMatchers("/usr/update/profile").permitAll()//
                .antMatchers("/usr/update/password").permitAll()//
                .antMatchers("/usr/delete").permitAll()//
                .antMatchers("/usr/one/{id}").permitAll()//
                .antMatchers("/usr/count").permitAll()//
                .antMatchers("/board/save").permitAll()//
                .antMatchers("/board/delete").permitAll()//
                .antMatchers("/board/delete/{brdNo}").permitAll()//
                .antMatchers("/board/count").permitAll()//
                .antMatchers("/board/all").permitAll()//
                .antMatchers("/board/board-all").permitAll()//
                .antMatchers("/board/one/{brdNo}").permitAll()//
                .antMatchers("/board/find/{brdNo}").permitAll()//
                .antMatchers("/board/exists/{brdNo}").permitAll()//
                .antMatchers("/board/option/{brdTitle}").permitAll()//
                .antMatchers("/board/board-number/{brd}").permitAll()//
                .antMatchers("/board/search").permitAll()//
                .antMatchers("/board/update/{brdNo}").permitAll()//
                .antMatchers("/products/save").permitAll()//
                .antMatchers("/products/delete").permitAll()//
                .antMatchers("/products/delete/{prdNo}").permitAll()//
                .antMatchers("/products/count").permitAll()//
                .antMatchers("/products/all").permitAll()//
                .antMatchers("/products/one/{prdNo}").permitAll()//
                .antMatchers("/products/find/{prdNo}").permitAll()//
                .antMatchers("/products/exists/{prdNo}").permitAll()//
                .antMatchers("/products/product-number/{prdNo}").permitAll()//
                .antMatchers("/products/category/{ctgName}").permitAll()//
                .antMatchers("/products/edit/{prdNo}").permitAll()//
                .antMatchers("/payment/save").permitAll()//
                .antMatchers("/payment/delete").permitAll()//
                .antMatchers("/payment/count").permitAll()//
                .antMatchers("/payment/all").permitAll()//
                .antMatchers("/payment/one/{id}").permitAll()//
                .antMatchers("/payment/find/{id}").permitAll()//
                .antMatchers("/payment/exists/{id}").permitAll()//
                .antMatchers("/receiver/save").permitAll()//
                .antMatchers("/receiver/delete").permitAll()//
                .antMatchers("/receiver/count").permitAll()//
                .antMatchers("/receiver/all").permitAll()//
                .antMatchers("/receiver/one/{id}").permitAll()//
                .antMatchers("/receiver/find/{id}").permitAll()//
                .antMatchers("/receiver/exists/{id}").permitAll()//
                .antMatchers("/h2-console/**/**").permitAll()
                // Disallow everything else..
                .anyRequest().authenticated();

        // If a user try to access a resource without having enough permissions
        http.exceptionHandling().accessDeniedPage("/login");

        // Apply JWT
        // http.apply(new SecurityConfig(provider));

        // Optional, if you want to test the API from a browser
        // http.httpBasic();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")

                // allow anonymous resource requests
                .antMatchers(
                        "/",
                        "/h2-console/**"
                );
    }
}
