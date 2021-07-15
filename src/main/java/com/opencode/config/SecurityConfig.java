package com.opencode.config;

import com.opencode.service.UserDetailServiceImpl;
import com.opencode.utils.Md5PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置
 *
 * @author fu.yuanming
 * @date 2021-05-20
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailServiceImpl userDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
				.authorizeRequests()
				// 放行地址
				.antMatchers("/login").anonymous()
				.antMatchers("/swagger-ui.html").anonymous()
				.antMatchers("/swagger-resources/**").anonymous()
				.antMatchers("/webjars/**").anonymous()
				.antMatchers("/*/api-docs").anonymous()
				.anyRequest().authenticated()
				.and().headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new Md5PasswordEncoder());
    }

}
