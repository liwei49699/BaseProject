package com.example.baselibrary.mvp.presenter;


import com.example.baselibrary.mvp.model.IBaseModel;
import com.example.baselibrary.mvp.view.IBaseView;

/**
 * 执行者的规范
 */
public interface IBasePresenter<V extends IBaseView,M extends IBaseModel> {

    void onAttachView(V view, M model);
    void onDetachView();
}
