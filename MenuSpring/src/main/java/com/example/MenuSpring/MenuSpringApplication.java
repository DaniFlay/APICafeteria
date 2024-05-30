package com.example.MenuSpring;

import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication()
public class MenuSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(MenuSpringApplication.class, args);


	}
}
