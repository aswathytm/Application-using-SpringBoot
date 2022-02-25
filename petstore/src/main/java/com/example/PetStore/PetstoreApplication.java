package com.example.PetStore;

import com.example.PetStore.User.Model.UserModel;
import com.example.PetStore.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PetstoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PetstoreApplication.class, args);

	}
//	@Autowired
//	UserRepository userRepository;
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	@Override
//	public void run(String... args) throws Exception {
//
//		//UserModel user = new UserModel("Aswathy", "Aswathy", "TM", passwordEncoder.encode("qburst123"), "aswathytm98@gmail.com", "+91 9847435658", 1);
//		//userRepository.save(user);
//
//	}

}
