package com.person.liwei.dagger.simple;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.person.liwei.R;
import com.ruffian.library.widget.RTextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DaggerUseActivity extends AppCompatActivity implements IDaggerView {

    @BindView(R.id.rtv_user_show)
    RTextView mRtvUserShow;
    @Inject
    DaggerPresenter mDaggerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_use);
        ButterKnife.bind(this);

        DaggerDaggerComponent.builder()
                .daggerModule(new DaggerModule(this))
                .build()
                .inject(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.rtv_user_show)
    public void onShowUserInfo() {

        mDaggerPresenter.showUserInfo();
    }

    interface OnCallaBackListener{

        void inject(MyListener myListener);
    }

    class MyListener{

    }

    class MyClass implements OnCallaBackListener{

        private MyListener mMyListener;

        @Override
        public void inject(MyListener myListener) {

            mMyListener = myListener;
        }
    }

    public void useDagger(){

        MyClass myClass = new MyClass();
        myClass.inject(new MyListener());
    }

}
