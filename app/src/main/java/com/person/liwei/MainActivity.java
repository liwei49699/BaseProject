package com.person.liwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.person.liwei.anim.CustomerObjectAnimActivity;
import com.person.liwei.anim.LayoutAnimActivity;
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
    }

    private void jumpActivity(Class cls){

        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
