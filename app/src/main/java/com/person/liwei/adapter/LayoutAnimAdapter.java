package com.person.liwei.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.person.liwei.R;

import java.util.List;

public class LayoutAnimAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public LayoutAnimAdapter(@Nullable List<String> data) {

        super(R.layout.item_layout_anim,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_item,item);
    }
}
