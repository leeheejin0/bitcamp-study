// Dynamic SQL - if 태그 사용법(사용 후)
package com.eomcs.mybatis.ex04.c;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mybatis.vo.Board;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("제목?(건너뛰기: 빈 문자열) ");
    String title = keyboard.nextLine();

    System.out.print("내용?(건너뛰기: 빈 문자열) ");
    String contents = keyboard.nextLine();

    keyboard.close();

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex04/c/mybatis-config.xml")).openSession();

    // where 절에 여러 개의 조건이 있을 경우 발생할 수 있는 문제점을 확인해보자. 
    // 테스트 1)
    //    - 제목, 내용 모두 빈 문자열로 입력한다. 
    //      => where 다음에 조건을 지정하는 SQL문이 없기 때문에 SQL 문법 오류가 발생한다. 
    // 테스트 2)
    //    - 제목만 입력한다. 
    //      => where 다음에 title 컬럼의 조건을 검사하는 코드가 붙기 때문에
    //         정상적으로 수행한다. 
    // 테스트 3) 
    //    - 내용만 입력한다. 
    //      => where 다음에 내용을 검사하는 코드가 붙는다. 
    //         문제는 제목을 검사하는 조건이 빠지는 바람에
    //         내용을 검사하는 코드 앞에 and가 있어서 SQL 문법 오류가 발생한다. 
    // 해결책)
    // - <where> 태그를 사용하면 조건이 비어있을 때 ㅓ

    HashMap<String,Object> params = new HashMap<>();
    if (title.length() > 0) {
      params.put("title", title);
    }

    if (contents.length() > 0) {
      params.put("contents", contents);
    }

    // Dynamic SQL 을 사용하면 여러 개의 SQL 문을 만들 필요가 없다.
    List<Board> boards = sqlSession.selectList("BoardMapper.select0210", params);

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


