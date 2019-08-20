package com.example.baselibrary.mvp.presenter;


import com.example.baselibrary.mvp.model.BaseModel;
import com.example.baselibrary.mvp.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * 控制业务逻辑的Presenter的基类
 */
public abstract class BasePresenter<V extends IBaseView,M extends BaseModel> implements IBasePresenter<V,M>{

    protected WeakReference<V> wView;
    public M mModel;

    @Override
    public void onAttachView(V view,M model) {

        wView = new WeakReference<>(view);
        mModel = model;
    }

    /**
     * 获取操作视图的对象
     * @return
     */
    protected V getView() {

        if(isViewAttached()) {

            return wView.get();
        }
        return null;
    }

    /**
     * 判断View是否依附
     * @return
     */
    public boolean isViewAttached() {

        return wView != null && wView.get() != null;
    }

    @Override
    public void onDetachView() {

        if (wView != null) {
            wView.clear();
            wView = null;
        }
    }
}
