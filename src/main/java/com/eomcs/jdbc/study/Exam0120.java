package com.eomcs.jdbc.study;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exam0120 {
  public static void main(String[] args) {

    try {
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
