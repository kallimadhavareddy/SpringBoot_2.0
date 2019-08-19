package tk.madhavareddy.digitaldiary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration


public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource(name = "userService")
    private UserDetailsService userDetailsService;
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/diaries/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/diaries").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/diaries/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/diaries/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/diaries/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
