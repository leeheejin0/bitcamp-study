package com.eomcs.jdbc.study;

import java.sql.DriverManager;

public class Exam0140 {
  public static void main(String[] args) {
    System.out.printf("java.home=%s\n", System.getProperty("java.home"));
    System.out.printf("user.home=%s\n", System.getProperty("user.home"));
    System.out.printf("jdbc=%s\n", System.getProperty("jdbc.drivers"));

    System.setProperty("jdbc.drivers","com.eomcs.jdbc.ex1.MyDriver");
    System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.drivers"));
    try {
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);

    } catch (Exception e) {

    }
  }
}
