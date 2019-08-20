package com.person.liwei.project.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.baselibrary.mvp.contract.ILoginContract;
import com.example.baselibrary.mvp.model.LoginModelImp;
import com.example.baselibrary.mvp.presenter.LoginPresentImp;
import com.example.baselibrary.mvp.view.BaseMvpActivity;
import com.example.baselibrary.util.AccountCheckUtils;
import com.example.baselibrary.util.adapter.ATextTWatcher;
import com.gyf.barlibrary.ImmersionBar;
import com.person.liwei.R;
import com.ruffian.library.widget.RTextView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity<ILoginContract.LoginPresenter, ILoginContract.LoginModel> implements ILoginContract.ILoginView {

    @BindView(R.id.til_phone)
    TextInputLayout tilPhone;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.rtv_login)
    RTextView rtvLogin;
    private ImmersionBar mImmersionBar;
    private String mPhoneStr;
    private String mPasswordStr;

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void loginStatusShow(int code, String message) {

        Log.d("--TAG--" , "loginStatusShow: " + message);
    }

    private void addAccountAndPasswordListener() {

        etPhone.addTextChangedListener(new ATextTWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                tilPhone.setErrorEnabled(false);
                if(TextUtils.isEmpty(s)) {

                    rtvLogin.setEnabled(false);
                } else {

                    if(!TextUtils.isEmpty(etPassword.getText())) {

                        rtvLogin.setEnabled(true);
                    }
                }
            }
        });

        etPassword.addTextChangedListener(new ATextTWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                tilPassword.setErrorEnabled(false);
                if(TextUtils.isEmpty(s)) {

                    rtvLogin.setEnabled(false);
                } else {

                    if(!TextUtils.isEmpty(etPhone.getText())) {

                        rtvLogin.setEnabled(true);
                    }
                }
            }
        });
    }


    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean hasTitleBar() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.window_bg)
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected void onDestroy() {

        mPresenter.interruptRequest();
        super.onDestroy();

        if (mImmersionBar != null) {

            mImmersionBar.destroy();
        }


    }

    @Override
    protected void init() {

        //输入监听监听
        addAccountAndPasswordListener();
    }

    @Override
    protected ILoginContract.LoginModel createModel() {
        return new LoginModelImp();
    }

    @Override
    protected ILoginContract.LoginPresenter createPresenter() {
        return new LoginPresentImp(this, mModel);
    }

    @OnClick({R.id.rtv_register, R.id.rtv_find_password, R.id.rtv_login, R.id.rtv_user_protocol, R.id.rtv_login_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
        }
    }

    private void startLogin() {
        
        if(judgeInfo()) {

            mPresenter.requestLogin(mPhoneStr, mPasswordStr);
        }
    }

    private boolean judgeInfo() {

        mPhoneStr = etPhone.getText().toString();
        mPasswordStr = etPassword.getText().toString();
        
        if(AccountCheckUtils.isPhoneFormat(mPhoneStr)) {

            tilPhone.setError("手机号码格式不正确");
            return false;
        }

        if(mPasswordStr.length() < 6) {

            tilPassword.setError("密码过于简单");
            return false;
        }
        return true;
    }
}
