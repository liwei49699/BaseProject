package com.person.liwei.phone.di.module;

import android.app.ProgressDialog;

import com.person.liwei.phone.data.RecommendModel;
import com.person.liwei.phone.data.http.ApiService;
import com.person.liwei.phone.presenter.contract.RecommendContract;
import com.person.liwei.phone.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RemmendModule {

    private RecommendContract.View mView;
    public RemmendModule(RecommendContract.View view){

        this.mView = view;
    }

    @Provides
    public RecommendContract.View provideView(){

        return mView;
    }

    @Provides
    public RecommendModel privodeModel(ApiService apiService){

        return  new  RecommendModel(apiService);
    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view){

        return new ProgressDialog(((RecommendFragment)view).getActivity());
    }
}
