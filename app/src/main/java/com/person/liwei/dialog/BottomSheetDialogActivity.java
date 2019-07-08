package com.person.liwei.dialog;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.person.liwei.R;
import com.person.liwei.adapter.BottomSheetDialogAdapter;
import com.person.liwei.utils.ScreenUtils;
import com.person.liwei.utils.Utils;
import com.person.liwei.widget.CommonBottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialogActivity extends AppCompatActivity {

    private CommonBottomSheetDialog mBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog);

        findViewById(R.id.rtv_dialog_show).setOnClickListener(v -> showBottomDialog());
    }

    private void showBottomDialog() {

        mBottomSheetDialog = new CommonBottomSheetDialog(this,R.style.dialogTheme);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            strings.add("子条目：" + i);
        }
        mBottomSheetDialog.setData(strings);
        mBottomSheetDialog.show();
    }
}
