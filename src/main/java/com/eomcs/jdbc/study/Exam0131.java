package com.eomcs.jdbc.study;

import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;

public class Exam0131 {

  public static void main(String[] args) {
    try {
      Properties props = new Properties();
      props.load(new FileReader("./jdbc-driver.properties"));
      System.out.println(props.getProperty("jdbc.driverClassName"));
      System.out.println(props.getProperty("jdbc.url"));

      Class.forName(props.getProperty("jdbc.driverClassName"));
      java.sql.Driver driver = DriverManager.getDriver(props.getProperty("jdbc.url"));
      System.out.println(driver);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
