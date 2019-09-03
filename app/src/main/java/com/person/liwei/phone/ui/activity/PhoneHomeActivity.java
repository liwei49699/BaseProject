package com.person.liwei.phone.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.person.liwei.R;
import com.person.liwei.phone.di.component.AppComponent;
import com.person.liwei.phone.ui.adapter.ViewPagerAdapter;

import butterknife.BindView;

public class PhoneHomeActivity extends BaseActivity {


    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private View headerView;

    @Override
    public int setLayout() {
        return R.layout.activity_phone_home;
    }

    @Override
    public void setupAcitivtyComponent(AppComponent appComponent) {

    }

    @Override
    public void init() {

        initDrawerLayout();
        initTabLayout();
    }

    private void initTabLayout() {

        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initDrawerLayout() {

        headerView = mNavigationView.getHeaderView(0);
        headerView.setOnClickListener(v -> Toast.makeText(PhoneHomeActivity.this, "headerView clicked", Toast.LENGTH_LONG).show());

        mNavigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.menu_app_update:
                    Toast.makeText(PhoneHomeActivity.this, "点击了应用更新", Toast.LENGTH_LONG).show();
                    break;

                case R.id.menu_message:
                    Toast.makeText(PhoneHomeActivity.this, "点击了消息", Toast.LENGTH_LONG).show();
                    break;
            }

            return false;
        });


        mToolBar.inflateMenu(R.menu.toolbar_menu);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);
        drawerToggle.syncState();
        mDrawerLayout.addDrawerListener(drawerToggle);
    }
}
