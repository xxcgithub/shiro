package com.luban.shiro1;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Create by xxc on 2019/3/23 13:50
 */
public class Md5Test {

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123","xiao");
        System.out.println(md5Hash.toString());
    }
}
