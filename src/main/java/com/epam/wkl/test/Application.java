package com.epam.wkl.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
Application .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
@SpringBootApplication
@ComponentScan("com.epam")
public class Application {

  public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
  }
}