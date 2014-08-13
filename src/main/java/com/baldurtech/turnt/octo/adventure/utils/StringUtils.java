package com.baldurtech.turnt.octo.adventure.utils;

public class StringUtils {
    static public boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    static public boolean isNotBlank(String str) {
        return !isBlank(str);
    }

}
