package com.jdk8;

public class Lambda表达式 {
	public static void main(String[] args) {
		Converter c = (int param) -> System.out.println(param);
		c.convert(12);
		
		// 类型声明
	    MathOperation addition = (int a, int b) -> a + b;
	    
	    // 不用类型声明
	    MathOperation subtraction = (a, b) -> a - b;
	    
	    // 大括号中的返回语句
	    MathOperation multiplication = (int a, int b) -> { return a * b; };
	    
	    // 没有大括号及返回语句
	    MathOperation division = (int a, int b) -> a / b;
	    
	    System.out.println(operate(1,2,multiplication));
	    System.out.println(operate(4,2,division));
	}
	
	//函数式接口，内部只能有一个方法
	public interface Converter{
        void convert(int i);
//        void test(int i,int j);
    }
	
	private static int operate(int a, int b, MathOperation mathOperation){
	   return mathOperation.operation(a, b);
	}
}

interface MathOperation {
    int operation(int a, int b);
}
