package com.person.liwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.person.liwei.anim.CustomerObjectAnimActivity;
import com.person.liwei.anim.LayoutAnimActivity;
import com.person.liwei.dagger.test.DaggerTestActivity;
import com.person.liwei.dagger.simple.DaggerUseActivity;
import com.person.liwei.dagger.really.DaggerReallyActivity;
import com.person.liwei.dialog.BottomSheetDialogActivity;

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
    }

    private void jumpActivity(Class cls){

        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
