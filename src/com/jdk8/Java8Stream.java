package com.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
	public static void main(String[] argv) {
		//Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()); 
		System.out.println("筛选列表: " + filtered);
		
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("| "));
		System.out.println("合并字符串: " + mergedString);
		
		//Filter
		// 获取空字符串的数量
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		//map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		numbers.stream().map( i -> i*i).distinct().forEach(System.out::println);
		System.out.println("map 方法实例:"+squaresList);
	}
}
