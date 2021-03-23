package com.eomcs.jdbc.study;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exam0110 {
  public static void main(String[] args) {
    try {
      java.sql.Driver mariadbDriver = new org.mariadb.jdbc.Driver();

      DriverManager.registerDriver(mariadbDriver);

      System.out.println("JDBC 드라이버 로딩 및 등록 완료!");

      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb://");
      System.out.println(driver);


    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
