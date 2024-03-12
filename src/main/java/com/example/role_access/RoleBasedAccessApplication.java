package com.example.role_access;

import com.example.role_access.entity.User;
import com.example.role_access.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RoleBasedAccessApplication {


	public static void main(String[] args) {
		SpringApplication.run(RoleBasedAccessApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (PasswordEncoder passwordEncoder, UserRepository userRepository) {
		return args -> {
			if(userRepository.findAll().isEmpty()) {
				User user1 = new User();
				user1.setName("ABC");
				user1.setRole("ROLE_USER_A");
				user1.setEmail("abc@gmail.com");
				user1.setPassword(passwordEncoder.encode("123"));
				userRepository.save(user1);

				User user2 = new User();
				user2.setName("DEF");
				user2.setRole("ROLE_USER_B");
				user2.setEmail("def@gmail.com");
				user2.setPassword(passwordEncoder.encode("123"));
				userRepository.save(user2);

				User user3 = new User();
				user3.setName("GHI");
				user3.setRole("ROLE_USER_C");
				user3.setEmail("ghi@gmail.com");
				user3.setPassword(passwordEncoder.encode("123"));
				userRepository.save(user3);

				User user4 = new User();
				user4.setName("JKL");
				user4.setRole("ROLE_USER_D");
				user4.setEmail("jkl@gmail.com");
				user4.setPassword(passwordEncoder.encode("123"));
				userRepository.save(user4);

				User admin = new User();
				admin.setName("Nam nai");
				admin.setRole("ROLE_ADMIN");
				admin.setEmail("admin@gmail.com");
				admin.setPassword(passwordEncoder.encode("123"));
				userRepository.save(admin);
			}
		};
	}

}
