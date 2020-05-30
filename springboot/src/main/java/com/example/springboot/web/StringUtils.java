package com.example.springboot.web;

import java.util.Collection;
import java.util.Map;

/**
 * @author 阿康
 * @date 2020/5/30 12:22
 * @ClassName: StringUtils
 * @description:
 */
public class StringUtils {

    public static void main(String[] args) {
        String str = "";
        System.out.println(isEmpty(str));
    }

    /**
     * 判断字符串是否为空(包含null与"")
     * @param str 判断值
     *
     * @return 空返回true  不为空false
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str.trim()) || "null".equals(str.trim().toLowerCase());
    }


    /**
     * 判断Object是否为空
     * @param obj 任意类型
     * @return boolean
     */
    public static boolean objectIsEmpty(Object obj) {
        if (obj == null || "".equals(obj)) {
            return true;
        }
        if (obj instanceof String){
            return ("".equals(obj) || "0".equals(obj));
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue() == 0;
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj);
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        return false;
    }
}
