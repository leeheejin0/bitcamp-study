// 오버라이딩(overriding) - 리턴 타입
package com.eomcs.oop.ex06.c;

public class Exam0610 {

  static class A {}
  static class B extends A {}
  static class C extends B {}

  static class AFactory {
    A create() {
      return new A();
    }
  }
  static class BFactory extends AFactory {
    @Override
    B create() {
      return new B();
    }
  }
  static class CFactory extends BFactory {
    @Override
    C create() {
      return new C();
    }
  }
  public static void main(String[] args) {
    new CarFactory().makeCar().run();
    new SedanFactory().makeCar().run();
    new TruckFactory().makeCar().run();
    new DumpTruckFactory().makeCar().run();
    new DumpTruckFactory2().makeCar().run();
  }
}








