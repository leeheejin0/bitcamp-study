package com.eomcs.jdbc.study;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exam0111 {
  public static void main(String[] args) {
    try {
      java.sql.Driver mariadbDriver = new org.mariadb.jdbc.Driver();
      DriverManager.registerDriver(mariadbDriver);

      java.sql.Driver driver = DriverManager.getDriver("jdbc:oracle:");
      System.out.println(driver);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}