package com.luban.shrio;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by xxc on 2019/3/22 22:30
 */
public class MapTest {
    Map<String,String> map2 = new HashMap<>();
    {
        map2.put("xiao1","123");

    }
    @Test
    public void  getTest (){
        String a = map2.get("xiao");
        System.out.println(a);
    }

}
