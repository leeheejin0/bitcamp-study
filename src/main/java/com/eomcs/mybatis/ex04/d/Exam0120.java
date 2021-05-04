// Dynamic SQL - set 태그의 필요성
package com.eomcs.mybatis.ex04.d;

import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    Board board = new Board();

    System.out.print("변경할 게시글의 번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("제목? ");
    String input = keyboard.nextLine();
    if (input.length() > 0) {
      board.setTitle(input);
    }

    System.out.print("내용? ");
    input = keyboard.nextLine();
    if (input.length() > 0) {
      board.setContent(input);
    }

    keyboard.close();

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex04/d/mybatis-config.xml")).openSession(true);

    // if 태그를 활용하면 전체 컬럼이 아니라 일부 항목만 변경하는 SQL을 만들 수 있다. 
    //
    int count = sqlSession.update("BoardMapper.update2", board);

    System.out.println(count);

    sqlSession.close();
  }

}


