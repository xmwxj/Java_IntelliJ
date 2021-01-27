package com.test;

/**
 * @author Nansen
 * @create 2020/8/6 13:56
 */
public class TestClass {
    public static void main(String[] args) {
        System.out.println(TestClass.class.getResource("").getPath());
//        B b1 = new B();
//        B b2 = new B();
//        A a = new A(2);
//        b1.setA(a);
//        b2.setA(b1.getA());
//        b2.getA().setI(5);
//        System.out.println(b1.getA().getI());
    }
}

class B{
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }
}

class A{
    private int i;

    A(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}