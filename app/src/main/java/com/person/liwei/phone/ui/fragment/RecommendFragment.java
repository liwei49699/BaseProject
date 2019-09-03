package com.person.liwei.phone.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.person.liwei.R;
import com.person.liwei.phone.bean.AppInfo;
import com.person.liwei.phone.di.component.AppComponent;
import com.person.liwei.phone.di.component.DaggerRecommendComponent;
import com.person.liwei.phone.di.module.RemmendModule;
import com.person.liwei.phone.presenter.RecommendPresenter;
import com.person.liwei.phone.presenter.contract.RecommendContract;
import com.person.liwei.phone.ui.adapter.RecomendAppAdatper;
import com.person.liwei.phone.ui.decoration.DividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;
    @Inject
    ProgressDialog mProgressDialog;
    private RecomendAppAdatper mAdatper;

    @Override
    public int setLayout() {
        return R.layout.fragment_recomend;
    }

    @Override
    public void setupAcitivtyComponent(AppComponent appComponent) {

        DaggerRecommendComponent.builder().appComponent(appComponent)
                .remmendModule(new RemmendModule(this)).build().inject(this);
    }

    @Override
    public void init() {

        mPresenter.requestDatas();
    }

    private void initRecycleView(List<AppInfo> datas){

        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //为RecyclerView设置分割线(这个可以对DividerItemDecoration进行修改，自定义)
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL_LIST));
        //动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdatper = new RecomendAppAdatper(getActivity(),datas);
        mRecyclerView.setAdapter(mAdatper);
    }


    @Override
    public void showResult(List<AppInfo> datas) {
        initRecycleView( datas);
    }

    @Override
    public void showNodata() {

        Toast.makeText(getActivity(),"暂时无数据，请吃完饭再来", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了："+msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLodading() {

        mProgressDialog.show();
    }

    @Override
    public void dimissLoading() {

        if(mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }
}
