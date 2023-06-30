package com.sda.QuickBite;

import com.sda.QuickBite.utils.SendEmail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class QuickBiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickBiteApplication.class, args);
////		List<String> emailList = List.of("romuluce@me.com", "elymihaib@gmail.com", "costin.ionut94@gmail.com"); // replace with the recipient's email address
//		List<String> emailList = List.of("romuluce@me.com"); // replace with the recipient's email address
//		SendEmail.send(emailList);
	}


}



