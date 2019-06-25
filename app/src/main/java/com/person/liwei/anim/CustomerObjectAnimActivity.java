package com.person.liwei.anim;

import android.animation.ObjectAnimator;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.person.liwei.R;
import com.person.liwei.Config;
import com.person.liwei.wraper.ViewWraper;

public class CustomerObjectAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_object_anim);

        ImageView ivCustomerAnim = findViewById(R.id.iv_customer_anim);
        ViewWraper viewWraper = new ViewWraper(ivCustomerAnim);
        ObjectAnimator.ofInt(viewWraper,"height",600).setDuration(1000L).start();
        Log.d("--TAG--", "onCreate: " + getPackageName());

        String channelId = "default";
        try {
            ApplicationInfo appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName()
                            , PackageManager.GET_META_DATA);
            channelId = appInfo.metaData.getString("CHANNEL_NAME");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Log.d("--TAG--", "onCreate: " + channelId);

        Log.d("--TAG--", "onCreate: " + Config.BASE_URL_CHECK);
    }
}
