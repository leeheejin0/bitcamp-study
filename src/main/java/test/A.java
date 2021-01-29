package test;

public class A {
  void m1(B obj) {
    obj.y();
  }
  void m2() {
    B.x();
  }
}
