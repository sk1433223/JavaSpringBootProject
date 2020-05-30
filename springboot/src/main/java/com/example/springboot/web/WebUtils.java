package com.example.springboot.web;

/**
 * @author 阿康
 * @date 2020/5/30 12:06
 * @ClassName: WebUtils
 * @description:
 */
public class WebUtils {

    public static void main(String[] args) {
        boolean number = isNumber("78");
        boolean number1 = isNumber("12s");
        System.out.println(number);
        System.out.println(number1);
    }

    /**
     * 判断String是否为数字
     * @param str 参数
     */
    public static boolean isNumber(String str) {
        if (isEmpty(str)){
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }



    /**
     * 字符串空值判断
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0 || "null".equals(s) || "".equals(s);
    }

    /**
     * Object空值判断
     */
    public static boolean isEmpty(Object o) {
        return o == null  || "null".equals(o) || "".equals(o);
    }




}
