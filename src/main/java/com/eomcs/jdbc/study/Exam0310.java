package com.eomcs.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;

    try (Scanner keyScan = new Scanner(System.in)){
      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();

      System.out.print("입력하시겠습니까?(Y/n) ");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소하였습니다. ");
      }
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = 
            con.prepareStatement("insert into x_board(title,contents) values(?,?)");) {

      stmt.setString(1,  title);
      stmt.setString(2, contents);

      int count = stmt.executeUpdate();
      System.out.printf("%d개 입력 성공!", count);
    }

  }

}
