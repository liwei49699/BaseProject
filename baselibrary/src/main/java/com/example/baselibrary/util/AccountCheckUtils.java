package com.example.baselibrary.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 手机号码和邮箱检测工具类
 * @author Administrator
 */
public class AccountCheckUtils {

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str)throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isHKPhoneLegal(String str)throws PatternSyntaxException {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public static boolean isPhoneFormat(String str)throws PatternSyntaxException {
//        String regExp = "^(5|6|8|9)\\d{7}$";
//        String regExp = "String regex = \"^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$\";";

        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 判断邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try {
            String RULE_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            //正则表达式的模式
            Pattern regex = Pattern.compile(RULE_EMAIL);
            //正则表达式的匹配器
            Matcher matcher = regex.matcher(email);
            //进行正则匹配
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }


}
