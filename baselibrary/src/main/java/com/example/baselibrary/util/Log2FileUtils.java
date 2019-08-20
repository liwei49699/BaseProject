package com.example.baselibrary.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.baselibrary.util.manager.ThreadManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @describe 日志文件写入 静态方法c，e，g，t分别存入相应的文件
 * @author LiWei
 * @date 2018-7-31
 */
public class Log2FileUtils {

    private static Context mContext;
    /**
     * 用于保存日志的文件
     */
    private static File eFile;
    /**
     * 日志类型
     */
    private static final int E_LOG_FILE = 1;
    /**
     * 用于区分每天的日志
     */
    private static Date todayDate;
    /**
     * 日志中的时间显示格式
     */
    private static SimpleDateFormat logSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    /**
     * 日志文件夹的显示格式
     */
    private static SimpleDateFormat logFolderSDF = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    private static final String TAG = "Log2FileUtils";

    /**
     * 初始化日志库
     * @param context
     */
    public static void init(Context context) {

        //获取文件路径
        mContext = context;
        initLogFile();
    }

    private static void initLogFile() {

        //重置时间 至指定年月日
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        todayDate = new Date(year,month,day);

        //创建文件
        eFile = getLogFile(E_LOG_FILE);
    }

    public static void e(Object msg){

        write(msg,E_LOG_FILE);
    }

    /**
     * 写入日志文件的数据
     * @param str 需要写入的数据
     * @param logType 日志类型
     */
    public static void write(final Object str, final int logType) {

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        Date date = new Date(year,month,day);

        if(date.after(todayDate)) {

            initLogFile();
        }

        final String logStr = getFunctionInfo() + " - " + str + "";

        //封装线程池 防止大数据写入造成卡顿
        ThreadManager.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //同步，防止写错
                synchronized (Log2FileUtils.class){

                    File logFile;

                    switch (logType) {

                        case E_LOG_FILE :

                            logFile = eFile;
                            break;

                        default:

                            logFile = eFile;
                            break;
                    }

                    BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter(logFile, true));
                        bw.write(logStr);
                        bw.write("\r\n");

                    } catch (Exception e) {

                        Log.e(TAG, "日志写入文件时出错" + e.toString());
                    } finally {

                        if(bw != null) {

                            try {
                                bw.flush();
                                bw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * 获取APP日志文件
     * @return APP日志文件
     */
    private static File getLogFile(int logType) {

        File file;
        // 判断是否有SD卡或者外部存储器
        String logFolderFormat = logFolderSDF.format(new Date() );
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 有SD卡则使用SD - PS:没SD卡但是有外部存储器，会使用外部存储器
            // SD\Android\data\包名\files\Log\date\log.txt
            file = new File(mContext.getExternalFilesDir("Log").getPath() + "/" + logFolderFormat + "/");
        } else {
            // 没有SD卡或者外部存储器，使用内部存储器
//             \data\data\包名\files\Log\date\log.txt
            file = new File(mContext.getFilesDir().getPath() + "/Log/" + logFolderFormat + "/");
        }
        // 若目录不存在则创建目录
        if (!file.exists()) {
            file.mkdir();
        }

        File logFile;

        switch (logType) {
            case E_LOG_FILE :

                logFile = new File(file.getPath() + "/e_log.txt");
                break;

            default:

                logFile = new File(file.getPath() + "/e_log.txt");

                break;
        }

        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (Exception e) {
                Log.e(TAG, "创建日志写入文件失败" + e.toString());
            }
        }
        return logFile;
    }

    /**
     * 获取当前函数的信息,格式化日志信息
     * @return 当前函数的信息
     */
    private static String getFunctionInfo() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }

        for (StackTraceElement st : sts) {

            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(Log2FileUtils.class.getName())) {
                continue;
            }

            return "[" + logSDF.format(new Date()) + " " + st.getClassName() + " " + st
                    .getMethodName() + " Line:" + st.getLineNumber() + "]";
        }
        return "[获取失败]";
    }
}
