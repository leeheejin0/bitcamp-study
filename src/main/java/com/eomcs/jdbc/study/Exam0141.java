package com.eomcs.jdbc.study;

import java.sql.DriverManager;

public class Exam0141 {

  public static void main(String[] args) {
    System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.drivers"));

    try {
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
      System.out.println("test!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
