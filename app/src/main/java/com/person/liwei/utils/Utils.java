package com.person.liwei.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 16/12/08
 *     desc  : Utils初始化相关
 * </pre>
 */
public final class Utils {
    private static Pattern pattern = Pattern.compile("^[2-9]*$");
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(@NonNull final Context context) {
        Utils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }

    /**
     * 检测数据是否合法
     *
     * @param str
     * @return
     */
    public static boolean checkStringLawful(String str) {
        if (TextUtils.isEmpty(str)){return false;}
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean listIsNotEmpty(List list) {
        return list != null && !list.isEmpty();
    }

}
