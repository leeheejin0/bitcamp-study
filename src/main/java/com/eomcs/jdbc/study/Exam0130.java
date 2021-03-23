package com.eomcs.jdbc.study;

import java.sql.DriverManager;

public class Exam0130 {

  public static void main(String[] args) {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
