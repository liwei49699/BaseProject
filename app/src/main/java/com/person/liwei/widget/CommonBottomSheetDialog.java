package com.person.liwei.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.person.liwei.R;
import com.person.liwei.adapter.BottomSheetDialogAdapter;
import com.person.liwei.utils.ScreenUtils;

import java.util.List;

public class CommonBottomSheetDialog extends BottomSheetDialog {

    private Window mWindow;
    private int mPeekHeight = ScreenUtils.dp2px(500);
    private int mMaxHeight = ScreenUtils.dp2px(500);
    private BottomSheetBehavior<View> mBottomSheetBehavior;
    private BottomSheetDialogAdapter mBottomSheetDialogAdapter;
    private Context mContext;

    public CommonBottomSheetDialog(@NonNull Context context) {
        this(context,0);
    }

    public CommonBottomSheetDialog(@NonNull Context context, int theme) {
        super(context, theme);
        mContext = context;
        init();
    }

    protected CommonBottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {

        mWindow = getWindow();
        mBottomSheetDialogAdapter = new BottomSheetDialogAdapter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPeekHeight();
        setMaxHeight();
        setBottomSheetCallback();
        //

    }

    private void setPeekHeight() {

        if (mPeekHeight <= 0) {
            return;
        }

        if (getBottomSheetBehavior() != null) {
            mBottomSheetBehavior.setPeekHeight(mPeekHeight);
        }
    }

    private void setMaxHeight() {

        if (mMaxHeight <= 0) {
            return;
        }

        mWindow.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, mMaxHeight);
        mWindow.setGravity(Gravity.BOTTOM);
    }

    private void setBottomSheetCallback() {

        if (getBottomSheetBehavior() != null) {
            mBottomSheetBehavior.setBottomSheetCallback(mBottomSheetCallback);
            //收缩时跳过中间态
            mBottomSheetBehavior.setSkipCollapsed(true);
        }
    }

    private BottomSheetBehavior getBottomSheetBehavior() {

        if (mBottomSheetBehavior != null) {
            return mBottomSheetBehavior;
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_bottom,null);
         setContentView(view);//没有调用
//        View view = mWindow.findViewById(android.support.design.R.id.design_bottom_sheet);

        if (view == null) {
            return null;
        }

        view.findViewById(R.id.iv_close).setOnClickListener(v -> dismiss());
        RecyclerView rvList = view.findViewById(R.id.rv_list);

        rvList.setAdapter(mBottomSheetDialogAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));

        mBottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        return mBottomSheetBehavior;
    }


    private final BottomSheetBehavior.BottomSheetCallback mBottomSheetCallback
            = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet,
                                   @BottomSheetBehavior.State int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
                BottomSheetBehavior.from(bottomSheet).setState(
                        BottomSheetBehavior.STATE_COLLAPSED);
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {

        }
    };

    public void setData(List<String> strings) {

        mBottomSheetDialogAdapter.setNewData(strings);
    }
}
