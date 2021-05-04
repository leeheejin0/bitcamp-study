// 애노테이션 중복 사용
package com.eomcs.annotation.ex7;

@Employee("홍길")
@Employee("임꺽") // 중복 사용 불가!
public class MyClass2 {

  @Employee("홍길")
  @Employee("임꺽") // 중복 사용 불가!
  public void m1( int p) {}

  @Employee("홍길")
  @Employee("임꺽") // 중복 사용 불가!
  public void m2( int p) {}

}
