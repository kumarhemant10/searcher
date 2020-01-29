package com.hk.prj.vite;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hk.prj.vite.model.User;
import com.hk.prj.vite.repository.UserRepository;

/**
 * entry point of application
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.hk.prj.vite.model"}, basePackageClasses = {Application.class,	Jsr310JpaConverters.class })
public class Application extends SpringBootServletInitializer {
	
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//initial users 
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	User user = new User();
	    	user.setActive(Boolean.TRUE);
	    	user.setUserName("hkchauhan022@gmail.com");
	    	user.setPassword(passwordEncoder.encode("hemant123"));
	    	user.setEmail("hkchauhan022@gmail.com");
	        userRepository.save(user);
	      };
	   }
	

}

