package com.apiharas.webharas;

import com.apiharas.webharas.interfaces.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebharasApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebharasApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


//	@Bean
//	CommandLineRunner run(UserService userService){
//		return args -> {
//			userService.saveRole(new Role( null, "ROLE_USER"));
//			userService.saveRole(new Role( null, "ROLE_MANAGER"));
//			userService.saveRole(new Role( null, "ROLE_ADMIN"));
//			userService.saveRole(new Role( null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User
//					( 		null,
//							"joao",
//							"1234",
//							"João da Silva",
//							"joão@gmail.com",
//							"111.111.111-11",
//							"11 1111 1111",
//							"11 1111 1111",
//							1L,
//							new ArrayList<>()));
//
//			userService.saveUser(new User
//					( 		null,
//							"suzi",
//							"1234",
//							"Suzana da Silva",
//							"suzinha@gmail.com",
//							"112.111.111-11",
//							"11 1111 1111",
//							"11 1111 1111",
//							1L,
//							new ArrayList<>()));
//
//			userService.addRoleToUser("joao", "ROLE_USER");
//			userService.addRoleToUser("joao", "ROLE_MANAGER");
//			userService.addRoleToUser("suzi", "ROLE_USER");
//			userService.addRoleToUser("suzi", "ROLE_ADMIN");
//			userService.addRoleToUser("suzi", "ROLE_SUPER_ADMIN");
//		};
//	}

}
