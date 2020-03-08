package com.designPattern.CreatePattern;

import com.designPattern.A;
import com.designPattern.B;
import com.designPattern.C;
import com.designPattern.Food;

/**
 *
 * @author Nansen
 * 工厂方法模式，又称静态工厂模式
 * 常用的工厂模式是静态工厂，利用static方法，作为一种类似于常见的工具类Utils等辅助效果，一般情况下工厂类不需要实例化。
 */
public class FactoryMethod {

    private FactoryMethod(){}

    public static Food getA(){  return new A(); }
    public static Food getB(){  return new B(); }
    public static Food getC(){  return new C(); }
}

class Client{
    //客户端代码只需要将相应的参数传入即可得到对象
    //用户不需要了解工厂类内部的逻辑。
    public void get(String name){
        Food x = null ;
        if ( name.equals("A")) {
            x = FactoryMethod.getA();
        }else if ( name.equals("B")){
            x = FactoryMethod.getB();
        }else {
            x = FactoryMethod.getC();
        }
    }
}