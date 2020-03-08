package com.intelliJ.template;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Nansen
 * @create 2020/3/8 14:18
 */
public class TemplateTest {
    //模板7：prsf, psf, psfi, psfs
    private static final int flag=1;
    public static final int NUM=2;

    //模板一:psvm 和main
    public static void main(String[] args) {
        //模板二：sout
        System.out.println();
        //sout拓展:soutm
        System.out.println("TemplateTest.main");
        //sout拓展:soutp
        System.out.println("args = " + Arrays.deepToString(args));
        //sout拓展:soutv
        int num=10;
        System.out.println("num = " + num);
        //sout拓展: num.soutv
        System.out.println("num = " + num);

        //模板三：fori
        String[] array = new String[]{"a","b","c"};
        for (int i = 0; i < array.length; i++) {
        }
        //fori拓展：itar
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
        }
        //模板四：增强for循环：iter
        for (String s : array) {
        }
        //模板五：list.for
        ArrayList list = new ArrayList();
        for (Object o : list) {

        }
        //list.for拓展(正序遍历)：list.fori
        for (int i = 0; i < list.size(); i++) {

        }
        //list.for拓展(逆序遍历)：list.forr
        for (int i = list.size() - 1; i >= 0; i--) {

        }
        
        //模板六：ifn
        if (list == null) {
            
        }
        //ifn拓展：inn
        if (list != null) {
            
        }
        //ifn拓展：xxx.nn 或者xxx.null
        if (list != null) {

        }
        if (list == null) {

        }

    }
    public void method(){
        System.out.println("TemplateTest.method");
        String[] array = new String[]{"a","b","c"};
    }
}
