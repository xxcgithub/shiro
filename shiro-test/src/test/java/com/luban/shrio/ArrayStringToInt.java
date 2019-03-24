package com.luban.shrio;

import org.junit.Test;

/**
 * Create by xxc on 2019/3/22 18:25
 */
public class ArrayStringToInt {

    @Test
    public void getStringToInt (){

        String a = "1,2,3,4,5";
        String[] b = a.split(",");
        System.out.println(b);
        String e =null;
        for (int i = 0; i < b.length; i++) {
            e = b[i];
            System.out.println(e);
        }
        int[] c = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            c[i] =Integer.parseInt(b[i]);
        }
            int d = 0;
        for (int i = 0; i < c.length; i++) {
            d+=c[i];
        }
        System.out.println(d);
    }
}
