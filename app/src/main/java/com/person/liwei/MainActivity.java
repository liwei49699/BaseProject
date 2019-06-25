package com.person.liwei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.person.liwei.anim.CustomerObjectAnimActivity;
import com.person.liwei.anim.LayoutAnimActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_layout_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumpActivity(LayoutAnimActivity.class);
            }
        });

        findViewById(R.id.btn_layout_anim_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumpActivity(LayoutAnimActivity.class);
            }
        });

        findViewById(R.id.btn_customer_object_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jumpActivity(CustomerObjectAnimActivity.class);
            }
        });

        new Config();

    }

    private void jumpActivity(Class cls){

        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
