package com.person.liwei.pager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created on 2019-08-06 14:35
 * Description:
 *
 * @author LiGuangwei
 */
public class PagerFragment extends Fragment {

    private static String mTitle;

    public static PagerFragment getInsTance(String title) {
        mTitle = title;
        return new PagerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setText(mTitle);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(100,100,100,100);

        return textView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
