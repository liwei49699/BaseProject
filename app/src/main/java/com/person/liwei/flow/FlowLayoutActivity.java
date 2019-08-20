package com.person.liwei.flow;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.person.liwei.R;

import java.util.ArrayList;

public class FlowLayoutActivity extends AppCompatActivity {

    private ArrayList<String> hotSearchTestList;
    private RecyclerView mRcSearchHistory;
    private Paint mSearchHistoryPaint;
    private int mPaddingSize;
    private SearchHistoryAdapter mSearchHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);

        mRcSearchHistory = findViewById(R.id.rv_flow);
        hotSearchTestList = new ArrayList<>();
        String str = "";
        for (int i = 0; i < 100; i++) {
            str = str + "家";
            hotSearchTestList.add(str);
        }

        mRcSearchHistory.setHasFixedSize(true);
        mSearchHistoryPaint = new Paint();//画笔用来计算文字的宽度
        //设置文字的大小，注意布局文件里写的是sp，这里需要进行转换成对应的px，我这里就不写了
        mSearchHistoryPaint.setTextSize(40);
        //textview的大小，包括文字大小和左右内边距，所以这个值表示内边距大小，同样注意转换
        mPaddingSize = 100;
        //获取屏幕的宽度，我这里rccyclerview正好是屏幕的宽度，否则应替换为rec的宽度
        final int width = getWindowManager().getDefaultDisplay().getWidth();
        //这里讲网格的数量设置为屏幕的宽度，网格无限小
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, width);
        //设置每个文字占据的网格数
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //就是这里 需要测量文字的宽度，加上左右内边距
                int textWidth = (int) mSearchHistoryPaint.measureText(hotSearchTestList.get(position)) + mPaddingSize;
                //如果文字的宽度超过屏幕的宽度，那么我们就设置为屏幕宽度
                return textWidth > width ? width : textWidth;
            }
        });
        mRcSearchHistory.setLayoutManager(gridLayoutManager);
        mSearchHistoryAdapter = new SearchHistoryAdapter(hotSearchTestList);
        mRcSearchHistory.setAdapter(mSearchHistoryAdapter);
    }

    class SearchHistoryAdapter extends BaseQuickAdapter<String, BaseViewHolder>{

        public SearchHistoryAdapter(ArrayList<String> hotSearchTestList) {
            super(R.layout.item_layout_anim ,hotSearchTestList);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {


        }
    }
}
