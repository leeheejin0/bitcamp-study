// 클래스에 제네릭(generic) 적용하기 : 적용 후
package com.eomcs.generic.ex01;

// 2) 제네릭을 적용한 클래스
// - 클래스 전체에서 사용할 "타입 파라미터(타입 이름을 저장하는 변수)"를 선언하기
//      class 클래스명<타입파라미터명, 타입파라미터명, ...> {...}
// - 클래스가 다루는 어떤 타입이 있다고 가정하자. 그 타입을 T라고 부르겠다.
//

public class Exam0242 {

  static class Box<T> {
    T value;
    public T get() {return this.value;}
    public void set(T value) {this.value = value;}
  }

  public static void main(String[] args) {

    // 제네릭 클래스를 사용할 때,
    // 타입 파라미터의 값을 빼면 경고가 뜬다.
    // 내부적으로는 Object를 지정한다.
    // 즉 다음 코드는 Box<Object> b5 = new Box<Object>() 와 같다.
    //
    Box b5 = new Box(); // 경고!

    // 제네릭은 다형성의 유연함을 그대로 유지하면서
    // 특정 타입의 데이터를 다루도록 도와주는 매우 편리한 문법이다.

    // 결론:
    // => 제네릭 문법을 사용하면 Object 타입을 사용하는 것보다 편리하다.
    // => 각 타입 별로 클래스를 따로 정의한듯한 효과가 있다.
  }
}