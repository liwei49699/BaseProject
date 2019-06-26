package com.person.liwei.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class AppUtils {

    /**
     * 判断当前应用是否是debug状态
     */
    public static boolean isDebug() {
        try {
            ApplicationInfo info = Utils.getContext().getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
