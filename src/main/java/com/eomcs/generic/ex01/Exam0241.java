// 클래스에 제네릭(generic) 적용하기 : 적용 후
package com.eomcs.generic.ex01;

import java.util.Date;

// 2) 제네릭을 적용한 클래스
// - 클래스 전체에서 사용할 "타입 파라미터(타입 이름을 저장하는 변수)"를 선언하기
//      class 클래스명<타입파라미터명, 타입파라미터명, ...> {...}
// - 클래스가 다루는 어떤 타입이 있다고 가정하자. 그 타입을 T라고 부르겠다.
//

public class Exam0241 {

  static class Box<T> {
    T value;
    public T get() {return this.value;}
    public void set(T value) {this.value = value;}
  }

  public static void main(String[] args) {

    // 제네릭으로 지정한 타입이 아닌 것을 넣으려 하면 컴파일 오류가 발생한다. 
    // => 이것이 제네릭을 사용하는 이유이기도 하다.
    // => 즉 특정 클래스만 다루도록 제한할 수 있다.
    //
    Box<Date> b4 = new Box<>();

    // 다음과 같이 인스턴스를 생성할 때 지정한 타입이 아닌 것을 다루려고 하면
    // 컴파일 오류가 발생한다. 
    // b4.set("Hello!"); //컴파일 오류!

  }
}