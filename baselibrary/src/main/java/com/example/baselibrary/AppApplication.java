package com.example.baselibrary;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import me.jessyan.autosize.AutoSizeConfig;

public class AppApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = this;
        //初始化屏幕适配
        initAutoSize();

        Map map = new HashMap();
        Object put = map.put("abc", "ABC");
    }

    private void initAutoSize() {

        //三方页面在其他页面时需初始化
//        AutoSize.initCompatMultiProcess(this);
        AutoSizeConfig.getInstance()
                //单独适配Fragment
//                .setCustomFragment(true)
                //屏蔽系统字体大小
                .setExcludeFontScale(true)
                //屏幕适配监听器 分屏或缩放模式改变窗体大小
//                .setOnAdaptListener(new onAdaptListener() {
//                    @Override
//                    public void onAdaptBefore(Object target, Activity activity) {
//                        //系统会重绘当前的页面, 经测试在某些机型, 某些情况下系统不会重绘当前页面, ScreenUtils.getScreenSize(activity) 的参数一定要不要传 Application!!!
//                        AutoSizeConfig.getInstance().setScreenWidth(ScreenUtils.getScreenSize(activity)[0]);
//                        AutoSizeConfig.getInstance().setScreenHeight(ScreenUtils.getScreenSize(activity)[1]);
//                        LogUtils.d(String.format(Locale.ENGLISH, "%s onAdaptBefore!", target.getClass().getName()));
//                    }
//
//                    @Override
//                    public void onAdaptAfter(Object target, Activity activity) {
//                        LogUtils.d(String.format(Locale.ENGLISH, "%s onAdaptAfter!", target.getClass().getName()));
//                    }
//                })
                //设置为 true 则使用设备的实际屏幕高度, 不会减去状态栏高度
//                .setUseDeviceSize(false)
                //是否全局按照宽度进行等比例适配, 默认为 true, 如果设置为 false, AutoSize 会全局按照高度进行适配
//                .setBaseOnWidth(false)

                //设置屏幕适配逻辑策略类, 一般不用设置, 使用框架默认的就好
                ;
        //添加三方页面适配
//        AutoSizeConfig.getInstance().getExternalAdaptManager()
                //加入的 Activity 将会放弃屏幕适配, 一般用于三方库的 Activity, 详情请看方法注释
                //如果不想放弃三方库页面的适配, 请用 addExternalAdaptInfoOfActivity 方法, 建议对三方库页面进行适配, 让自己的 App 更完美一点
//                .addCancelAdaptOfActivity(DefaultErrorActivity.class)
                //为指定的 Activity 提供自定义适配参数, AndroidAutoSize 将会按照提供的适配参数进行适配, 详情请看方法注释
                //一般用于三方库的 Activity, 因为三方库的设计图尺寸可能和项目自身的设计图尺寸不一致, 所以要想完美适配三方库的页面
                //就需要提供三方库的设计图尺寸, 以及适配的方向 (以宽为基准还是高为基准?)
                //三方库页面的设计图尺寸可能无法获知, 所以如果想让三方库的适配效果达到最好, 只有靠不断的尝试
                //由于 AndroidAutoSize 可以让布局在所有设备上都等比例缩放, 所以只要您在一个设备上测试出了一个最完美的设计图尺寸
                //那这个三方库页面在其他设备上也会呈现出同样的适配效果, 等比例缩放, 所以也就完成了三方库页面的屏幕适配
                //即使在不改三方库源码的情况下也可以完美适配三方库的页面, 这就是 AndroidAutoSize 的优势
                //但前提是三方库页面的布局使用的是 dp 和 sp, 如果布局全部使用的 px, 那 AndroidAutoSize 也将无能为力
                //经过测试 DefaultErrorActivity 的设计图宽度在 380dp - 400dp 显示效果都是比较舒服的
//                .addExternalAdaptInfoOfActivity(DefaultErrorActivity.class, new ExternalAdaptInfo(true, 400));

    }
}
