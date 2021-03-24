package com.eomcs.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam0411 {

  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.println("내용? ");
      contents = keyScan.nextLine();
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into x_board(title,contents) values(?,?)",
            Statement.RETURN_GENERATED_KEYS);) {

      stmt.setString(1, title);
      stmt.setString(2, contents);
      int count = stmt.executeUpdate();
      System.out.printf("%d개 입력 성공!\n", count);

      try (ResultSet rs = stmt.getGeneratedKeys()) {
        rs.next();

        int no = rs.getInt(1);
        System.out.printf("입력된 게시글 번호: %d\n", no);
      }

    }

  }

}
