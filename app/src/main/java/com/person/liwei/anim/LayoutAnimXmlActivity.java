package com.person.liwei.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.person.liwei.R;
import com.person.liwei.adapter.LayoutAnimAdapter;

import java.util.ArrayList;
import java.util.List;

public class LayoutAnimXmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim_xml);

        RecyclerView rvLayoutAnim = findViewById(R.id.rv_layout_anim);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            strings.add("子条目：" + i);
        }
        rvLayoutAnim.setAdapter(new LayoutAnimAdapter(strings));
        rvLayoutAnim.setLayoutManager(new LinearLayoutManager(this));
    }
}
