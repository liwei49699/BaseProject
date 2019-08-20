package com.example.baselibrary.util.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Process;

import java.util.Stack;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created on 2019-07-24 14:42
 * Description:
 *   Activity管理器
 * @author LiGuangwei
 */
public class ActivityManager {

    private ActivityManager() {
    }

    /**
     * 静态内部类的单利模式（最优）
     */
    private static class ActivityManagerHolder{

        private static ActivityManager INSTANCE = new ActivityManager();
    }

    public static ActivityManager getInstance(){

        return ActivityManagerHolder.INSTANCE;
    }

    Stack<Activity> activityStack = new Stack<>();

    /**
     * 将Activity加入Stack
     * @param activity
     */
    public void addActivity(Activity activity){

        if(!activityStack.contains(activity)) {

            activityStack.add(activity);
        }
    }

    /**
     * 结束Activity并移除Stack
     * @param activity
     */
    public void finishActivity(Activity activity){

        if(activityStack.contains(activity)) {

            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 关闭所有的Activity
     */
    public void finishAllActivitys(){

        for (android.app.Activity Activity : activityStack) {
            if(!Activity.isFinishing()){
                Activity.finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用sett
     * @param context
     */
    public void exitApp(Context context){

        for (Activity activity : activityStack) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activityStack.clear();
        //获取应用程序管理器
        android.app.ActivityManager manager = (android.app.ActivityManager)context.getSystemService(ACTIVITY_SERVICE);
        //强制结束当前应用程序
        manager.killBackgroundProcesses(context.getPackageName());
        //杀死进程    android.os.Process;
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
