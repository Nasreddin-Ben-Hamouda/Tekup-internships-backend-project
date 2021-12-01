package com.internships.rest.data.config;

import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.internships.rest.data.filter.JwtFilter;
import com.internships.rest.data.services.impl.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    private UserDetailsServiceImpl userDetailsService;
    private JwtFilter jwtFilter;
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
    	return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// Enable CORS and disable CSRF
         http = http.cors().and().csrf().disable();

        // Set unauthorized requests exception handler
    	 http = http
    	            .exceptionHandling()
    	            .authenticationEntryPoint(
    	                (request, response, ex) -> {
    	                    response.sendError(
    	                        HttpServletResponse.SC_UNAUTHORIZED,
    	                        ex.getMessage()
    	                    );
    	                }
    	            )
    	            .and();
    	
        http.authorizeRequests()
                .antMatchers("/user/login").permitAll().filterSecurityInterceptorOncePerRequest(false)
                //.antMatchers("/user/whoami").permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
    }
    
   
    
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
