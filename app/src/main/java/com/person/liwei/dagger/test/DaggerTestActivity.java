package com.person.liwei.dagger.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.person.liwei.R;

import javax.inject.Inject;

public class DaggerTestActivity extends AppCompatActivity {

    @Inject
    Chef chef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_test);

        startCooking();
    }

    private void startCooking() {

//        Map<String,Boolean> booleanMap = new HashMap<>();
//        booleanMap.put("青椒肉丝",true);
//        booleanMap.put("鸡蛋炒蛋",false);
//        booleanMap.put("黄瓜炒火腿",true);
//        Menu menu = new Menu(booleanMap);
//        Chef chef = new Chef(menu);

        DaggerCookComponent.builder()
//                .cookModules(new CookModules())
                .build().injectA(this);
//        dagg
//        .builder()
//                .cookModules(new CookModules())
//                .build()
//                .injectA(this);
//
        String cook = chef.cook();
        Toast.makeText(DaggerTestActivity.this, cook, Toast.LENGTH_SHORT).show();
    }
}
