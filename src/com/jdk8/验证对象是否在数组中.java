package com.jdk8;

import java.util.Arrays;

public class 验证对象是否在数组中 {
	public static void main(String[] a) {
		String[] types= {"cntt","hktt","twtt"};
		System.out.println(exists(types,"twtt"));
		System.out.println(exists(types,"haha"));
	}

	public static boolean exists(String[] array,String code) {
		return Arrays.stream(array).anyMatch(code::equalsIgnoreCase);
	}
}
