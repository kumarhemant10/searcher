package com.hk.prj.vite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.hk.prj.vite.model.User;
import com.hk.prj.vite.service.UserService;

/**
 * entry point of application
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.hk.prj.vite.model"}, basePackageClasses = {Application.class,	Jsr310JpaConverters.class })
public class Application extends SpringBootServletInitializer {
	
	@Autowired UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//initial users 
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	List<User> users = getInitialUsers();
	    	userService.save(users);
	      };
	   }

	private List<User> getInitialUsers() {
		User adminUser = new User();
    	adminUser.setUserName("hemant");
    	adminUser.setPassword("hemant");
    	adminUser.setEmail("hkchauhan022@gmail.com");

		User testUser = new User();
		testUser.setUserName("test");
		testUser.setPassword("test");
		testUser.setEmail("hkchauhan022@gmail.com");

    	List<User> users = new ArrayList<User>();
    	users.add(adminUser);
    	users.add(testUser);
    	
		return users;
	}
	

}

