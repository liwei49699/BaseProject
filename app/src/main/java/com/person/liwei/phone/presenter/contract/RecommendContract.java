package com.person.liwei.phone.presenter.contract;

import com.person.liwei.phone.bean.AppInfo;
import com.person.liwei.phone.ui.BaseView;

import java.util.List;


public interface RecommendContract {

    interface View extends BaseView {

        void showResult(List<AppInfo> datas);
        void showNodata();
        void showError(String msg);
    }
}
