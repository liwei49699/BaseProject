package com.person.liwei.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.person.liwei.R;
import com.person.liwei.adapter.LayoutAnimAdapter;

import java.util.ArrayList;
import java.util.List;

public class LayoutAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim);

        RecyclerView cvLayoutAnim = findViewById(R.id.cv_layout_anim);

        LayoutAnimationController animationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.anim_zoom_in));
        animationController.setDelay(0.5F);
        animationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        cvLayoutAnim.setLayoutAnimation(animationController);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            strings.add("子条目：" + i);
        }
        cvLayoutAnim.setAdapter(new LayoutAnimAdapter(strings));
        cvLayoutAnim.setLayoutManager(new LinearLayoutManager(this));

    }
}
