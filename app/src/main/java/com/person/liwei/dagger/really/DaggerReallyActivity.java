package com.person.liwei.dagger.really;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.person.liwei.R;

import javax.inject.Inject;

public class DaggerReallyActivity extends AppCompatActivity {

//    @Inject
//    Really mReally;
    @Inject
    Simple mSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_really);

//        Really really = DaggerReallyComponent.builder().really(new Really("123")).build().getReally();
//        really.read();
//        DaggerReallyComponent.builder().really(new Really("123")).build().injectR(this);
//        mReally.read();
        Outer outer = DaggerReallyComponent.builder().build().getOuter();
        outer.write();

        ComeOn comeOn = DaggerReallyComponent.builder().provideModel(new ProvideModel()).build().getComeOn();
        comeOn.come();

        DaggerReallyComponent.builder().build().injectR(this);

        Log.d("--TAG--", "DaggerReallyActivity onCreate()" + mSimple.toString());
    }
}
