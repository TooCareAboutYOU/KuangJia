package com.kuangjia.main.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kuangjia.main.R;
import com.kuangjia.main.ui.widget.TranslucentScrollView;

/*
*
* 滑动逐渐显示标题栏
*
* */
public class ShowToolBarActivity extends AppCompatActivity implements TranslucentScrollView.OnScrollChangedListener {

    TranslucentScrollView scrollView;
    Toolbar toolbar;
    TextView tvBack;

    float headerHeight;  //顶部高度
    float minHeaderHeight;  //顶部最低高度，即Bar的高度


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tollbar);
        if (getSupportActionBar() !=null){
            getSupportActionBar().hide();
        }
        initView();

    }

    private void initView(){
        scrollView= (TranslucentScrollView) findViewById(R.id.scrollview);
        scrollView.setOnScrollChangedListener(this);
        toolbar= (Toolbar) findViewById(R.id.toolbar_header);
        toolbar.setBackgroundColor(Color.argb(0,18,176,242));
        tvBack= (TextView) findViewById(R.id.tv_back);
        tvBack.setTextColor(Color.argb(0,26,126,216));
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initMeasure();
    }
    private void initMeasure(){
        headerHeight=getResources().getDimension(R.dimen.dimen_300);
        minHeaderHeight=getResources().getDimension(R.dimen.dimen_609);
    }

    @Override
    public void OnScrollChangedListener(ScrollView who, int l, int t, int oldl, int oldt) {
        //Y轴偏移量
        float scrollY=who.getScrollY();
        //变化率
        float headerBarOffsetY=headerHeight-minHeaderHeight; //ToolBar与header高度的差值
        float offset=1-Math.max((headerBarOffsetY-scrollY)/headerBarOffsetY,0f);

        //Toolbar背景色透明度
        toolbar.setBackgroundColor(Color.argb((int)(offset*255),18,176,242));

        tvBack.setTextColor(Color.argb((int)(offset*255),26,126,216));

        //header背景图Y轴偏移
        //imgHead.setTranslation(scrollY/2);
    }
}
