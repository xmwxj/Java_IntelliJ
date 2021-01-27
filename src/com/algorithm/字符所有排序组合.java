package com.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nansen
 * @create 2021/1/26 16:49
 */
public class 字符所有排序组合 {

    public static void main(String[] args) {
        Set<String> a = new HashSet<String>();
        Set<String> b = new HashSet<String>();
        Set<String> c = new HashSet<String>();

        a.add("a_b_C");
        a.add("b_b");
        a.add("c_b");

        //b.add("a_b");
        //b.add("f_c");
        //b.add("d_C");
        //笛卡尔积
        List<String> list1 = a.stream().flatMap(item1 -> b.stream().map(item2 -> fetch(item1,item2))).filter(item-> item != null).collect(Collectors.toList());
        System.out.println("list = " + list1);
        //全排序
        String[] array = {"a","b","c"};
        Set<String> set = new HashSet<String>();
        perm(array,0,2,set);
        System.out.println(set);

        Set<String> set2 = new HashSet<String>();
        System.out.println("set2 = " + set2);
    }

    public static void fillSet(Set<String> set){
        set.add("I am in fillSet");
        System.out.println("set = " + set);
    }

    public static String fetch(String item1,String item2){
        if(item1.startsWith(item2)){
            String str = item1.replaceFirst(item2,"");
            return str;
        }else{
            return null;
        }
    }

    /**
     * 字符串全排列
     * @param str
     * @return
     */
    public static Set<String> getPermutation(String str) {

        //创建 set 集合以避免重复排列
        Set<String> permutations = new HashSet<String>();

        //检查字符串是否为空
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            //递归的终止条件
            permutations.add("");
            return permutations;
        }

        //得到第一个字符
        char first = str.charAt(0);

        //获取剩余的子字符串
        String sub = str.substring(1);

        //递归调用getPersertion()
        Set<String> words = getPermutation(sub);

        //遍历 words
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){

                //将排列插入到set集合中
                permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
            }
        }
        return permutations;
    }

    static void perm(String[] list,int k,int m,Set<String> set){
        if(k==m){//没有到最后一个   所以还需要进行排列
            String sequential= Stream.of(list).collect(Collectors.joining("_"));
            set.add(sequential);
        }else{//进行排列
            for(int i = k;i<=m;i++){
                swap(list,i,k); //进行交换  从而完成全排列
                perm(list,k+1,m,set);
                swap(list,i,k); //需要交换回来 不然就会乱了顺序
            }
        }

    }

    private static void swap(String[] array,int index1,int index2) {
        String tmp = array[index1];
        array[index1] = array[index2];
        array[index2]=tmp;
    }
}
