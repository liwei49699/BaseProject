package com.person.liwei.phone.presenter;


import com.person.liwei.phone.bean.AppInfo;
import com.person.liwei.phone.bean.PageBean;
import com.person.liwei.phone.data.RecommendModel;
import com.person.liwei.phone.presenter.contract.RecommendContract;
import com.person.liwei.phone.ui.BaseView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    @Inject
    public RecommendPresenter(RecommendModel model, RecommendContract.View view) {
        super(model, view);
    }

    public void requestDatas() {

        mView.showLodading();
        mModel.getApps(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {

                if(response !=null){

                    mView.showResult(response.body().getDatas());
                }
                else{
                    mView.showNodata();
                }

                mView.dimissLoading();

            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {

                mView.dimissLoading();
                mView.showError(t.getMessage());

            }
        });
    }
}
