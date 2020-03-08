package com.algorithm;

/**
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。

 示例 1：

 输入：4
 输出：7
 解释：7 = 4 * 3 / 2 + 1
 示例 2：

 输入：10
 输出：12
 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 *
 */
public class 笨阶乘 {
	public static void main(String[] a) {
		System.out.println(clumsy(4));
		System.out.println(clumsy(10));
	}
	public static int clumsy(int N) {
		int count = 0;
		int result = 0;
		int resultTmp = 0;;
		while(N>0) {
			int i = count % 4;
			int j = count /4;
			switch(i) {
				case 0:
					resultTmp=N;
					break;
				case 1:
					resultTmp*=N;
					break;
				case 2:
					resultTmp/=N;
					break;
				case 3:
					if(j==0) {
						resultTmp+=N;
					}else {
						resultTmp-=N;
					}
					break;
			}
			if(j==0) {
				result=resultTmp;
			}else if(i==3 || N == 1){
				result-=resultTmp;
			}
			count++;
			N--;
		}
		return result;
	}
}
