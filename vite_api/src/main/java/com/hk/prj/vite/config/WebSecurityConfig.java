package com.hk.prj.vite.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hk.prj.vite.security.JwtConfig;
import com.hk.prj.vite.security.JwtTokenAuthenticationFilter;
import com.hk.prj.vite.security.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired private UserDetailsService userDetailsService;
	
	@Autowired JwtConfig jwtConfig;
	
	@Autowired 
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		// make sure we use stateless session; session won't be used to store user's state.
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		// handle an authorized attempts 
		.exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
		.and()
		// Add a filter to validate user credentials and add token in the response header
		// What's the authenticationManager()? 
		// An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
		// The filter needs this auth manager to authenticate the user.
		.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
		.addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		// allow all POST requests 
		.antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
		.antMatchers("/users/**").permitAll()
		// any other requests must be authenticated
		.anyRequest().authenticated();
	}
	
	@Bean
	public PasswordEncoder passwordencoder(){
		return new BCryptPasswordEncoder();
	}

}
