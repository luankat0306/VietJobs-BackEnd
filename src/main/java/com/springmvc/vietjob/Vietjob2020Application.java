package com.springmvc.vietjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Vietjob2020Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Vietjob2020Application.class, args);
	}
	
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

    	String pass = passwordEncoder.encode("123456");
        System.out.println(pass);
    }
}
