package com.baldurtech.turnt.octo.adventure;

public class StringUtils {
    static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

}
