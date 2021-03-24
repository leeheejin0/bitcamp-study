package com.eomcs.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    String no = null;
    String title = null;
    String contents = null;

    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.print("번호? ");
      no = keyboard.nextLine();

      System.out.print("제목? ");
      title = keyboard.nextLine();

      System.out.print("내용? ");
      contents = keyboard.nextLine();
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement()) {

      int count = stmt.executeUpdate(
          "update x_board set title = '" + title + 
          "', contents = '" + contents + 
          "' where board_id = " + no);

      if (count == 0) {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다. ");
      } else {
        System.out.println("변경하였습니다. ");
      }

    }

  }

}
