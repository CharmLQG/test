package com.charming.hello.test;

/**
 * STRING 判断
 */
public class StringUtil {

    public static Boolean isEmpty(String s) {
        return s == null || ("").equals(s.trim());
    }

    public static Boolean notEmpty(String s) {
        return s != null && !("").equals(s.trim());
    }
}
