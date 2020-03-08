package com.algorithm;

/**
 * 
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例 1:
 * "Let's take LeetCode contest"
 * "s'teL ekat edoCteeL tsetnoc" 
 */
public class 字符反转 {
	public static void main(String[] a) {
		System.out.println(reverseWords("abc efd osos"));
	}
	
	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		String[] strArray = s.split(" ");
		for (int i = 0; i < strArray.length; i++) {
			sb.append(new StringBuilder(strArray[i]).reverse()).append(" ");
		}
		return sb.toString().trim();
	}
}
