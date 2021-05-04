// Dynamic SQL - foreach 태그의 필요성
package com.eomcs.mybatis.ex04.e;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("검색어1? ");
    String keyword1 = keyboard.nextLine();

    System.out.print("검색어2? ");
    String keyword2 = keyboard.nextLine();

    System.out.print("검색어3? ");
    String keyword3 = keyboard.nextLine();

    keyboard.close();

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex04/e/mybatis-config.xml")).openSession();

    // 여러 개의 검색어로 데이터를 찾을 때
    // => 최대 3개의 검색어로 제한하는 경우

    HashMap<String,Object> params = new HashMap<>();
    params.put("keyword1", keyword1);
    params.put("keyword2", keyword2);
    params.put("keyword3", keyword3);

    // Dynamic SQL 을 사용하면 여러 개의 SQL 문을 만들 필요가 없다.
    List<Board> boards = sqlSession.selectList("BoardMapper.select1", params);

    for (Board b : boards) {
      System.out.printf("%d,%s,%s,%s,%d\n",
          b.getNo(),
          b.getTitle(),
          b.getContent(),
          b.getRegisteredDate(),
          b.getViewCount());
    }

    sqlSession.close();
  }

}


