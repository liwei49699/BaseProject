package com.person.liwei.pager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.person.liwei.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerAdapterActivity extends AppCompatActivity {

    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.tl_test)
    TabLayout mTlTest;
    @BindView(R.id.vp_test)
    ViewPager mVpTest;
    private ArrayList<String> mTitle;
    private ArrayList<PagerFragment> mFragment;
    private FragmentStatePagerAdapter mFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_adapter);
        ButterKnife.bind(this);

        mTitle = new ArrayList<>();
        mFragment = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            mTitle.add("选项卡--" + i);
            mFragment.add(PagerFragment.getInsTance("选项卡--" + i));

        }

        mFragmentPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }

            @Override
            public int getItemPosition(@NonNull Object object) {
                return POSITION_NONE;
            }
        };
        mVpTest.setAdapter(mFragmentPagerAdapter);

        mTlTest.setupWithViewPager(mVpTest);

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTlTest.addTab(mTlTest.newTab().setText("新增的"),1);
                mFragment.add(1,PagerFragment.getInsTance("选项卡--"));

                mFragmentPagerAdapter.notifyDataSetChanged();
            }
        });
    }
}
