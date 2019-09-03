package com.person.liwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.person.liwei.anim.CustomerObjectAnimActivity;
import com.person.liwei.anim.LayoutAnimActivity;
import com.person.liwei.dagger.test.DaggerTestActivity;
import com.person.liwei.dagger.simple.DaggerUseActivity;
import com.person.liwei.dagger.really.DaggerReallyActivity;
import com.person.liwei.dialog.BottomSheetDialogActivity;
import com.person.liwei.entity.RoomDataBaseActivity;
import com.person.liwei.flow.FlowLayoutActivity;
import com.person.liwei.gradle.Test;
import com.person.liwei.pager.PagerAdapterActivity;
import com.person.liwei.phone.ui.activity.PhoneHomeActivity;
import com.person.liwei.phone.ui.activity.WelcomeActivity;
import com.person.liwei.project.MyApplication;
import com.person.liwei.project.activity.SplashActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_layout_anim).setOnClickListener(v -> jumpActivity(LayoutAnimActivity.class));
        findViewById(R.id.btn_layout_anim_xml).setOnClickListener(v -> jumpActivity(LayoutAnimActivity.class));
        findViewById(R.id.btn_customer_object_anim).setOnClickListener(v -> jumpActivity(CustomerObjectAnimActivity.class));
        findViewById(R.id.btn_bottom_sheet_dialog).setOnClickListener(v -> jumpActivity(BottomSheetDialogActivity.class));
        findViewById(R.id.btn_dagger_test_simple_test).setOnClickListener(v -> jumpActivity(DaggerTestActivity.class));
        findViewById(R.id.btn_dagger_simple_use).setOnClickListener(v -> jumpActivity(DaggerUseActivity.class));
        findViewById(R.id.btn_dagger_really_use).setOnClickListener(v -> jumpActivity(DaggerReallyActivity.class));
        findViewById(R.id.btn_base_project).setOnClickListener(v -> jumpActivity(SplashActivity.class));
        findViewById(R.id.btn_flow_layout).setOnClickListener(v -> jumpActivity(FlowLayoutActivity.class));
        findViewById(R.id.btn_refresh_pager).setOnClickListener(v -> jumpActivity(PagerAdapterActivity.class));
        findViewById(R.id.btn_room_database).setOnClickListener(v -> jumpActivity(RoomDataBaseActivity.class));
        findViewById(R.id.btn_phone_helper_study).setOnClickListener(v -> jumpActivity(WelcomeActivity.class));


        Log.d("--TAG--", "PhoneHomeActivity onCreate()" + (getApplication() == MyApplication.mApplication));
    }

    private void jumpActivity(Class cls){

        Intent intent = new Intent(this,cls);
        startActivity(intent);

        Log.d("--TAG--", "PhoneHomeActivity jumpActivity()" + new Test());
    }
}
