package com.kuangjia.main.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import com.kuangjia.main.R;
import com.kuangjia.main.gridviewpager.Caterory;
import com.kuangjia.main.gridviewpager.GAdapter;
import com.kuangjia.main.gridviewpager.vAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridViewPagerActivity extends AppCompatActivity {

    public ViewPager vp;

//    {
//        List<Caterory> list=new ArrayList<Caterory>();
//        list.add(new Caterory("美食",R.drawable.ic_category_0));
//        list.add(new Caterory("电影",R.drawable.ic_category_1));
//        list.add(new Caterory("酒店",R.drawable.ic_category_2));
//        list.add(new Caterory("KTV",R.drawable.ic_category_3));
//        list.add(new Caterory("优惠买单",R.drawable.ic_category_4));
//        list.add(new Caterory("周边",R.drawable.ic_category_5));
//        list.add(new Caterory("火车票",R.drawable.ic_category_6));
//        list.add(new Caterory("外卖",R.drawable.ic_category_7));
//        list.add(new Caterory("休闲娱乐",R.drawable.ic_category_8));
//        list.add(new Caterory("都市丽人",R.drawable.ic_category_9));
//        list.add(new Caterory("今日新单",R.drawable.ic_category_10));
//        list.add(new Caterory("购物",R.drawable.ic_category_11));
//        list.add(new Caterory("旅游",R.drawable.ic_category_12));
//        list.add(new Caterory("生活服务",R.drawable.ic_category_13));
//        list.add(new Caterory("足疗",R.drawable.ic_category_14));
//        list.add(new Caterory("全部",R.drawable.ic_category_15));
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_pager);
        initView();
    }

    void initView(){
        vp=(ViewPager) findViewById(R.id.vp_pager);
        List<View> vList = new ArrayList<View>();//用来保存设置给ViewPager的视图（View）

        GridView gv = new GridView(this);
        gv.setNumColumns(4);
        gv.setAdapter(new GAdapter(getValue(0), this));
        vList.add(gv);

        GridView gv1 = new GridView(this);
        gv1.setNumColumns(4);
        gv1.setAdapter(new GAdapter(getValue(1), this));
        vList.add(gv1);

        vp.setAdapter(new vAdapter(vList));

    }

    public List<Caterory>  getValue(int page){//专门获取设置gridView的数据的方法
        List<Caterory> gList = new ArrayList<Caterory>();//用来保存设置给gridView的实体数据
        String[] category = new String[] { "美食", "电影", "酒店", "KTV", "优惠买单", "周边", "火车票", "外卖", "休闲娱乐", "丽人", "今日新单", "购物", "生活服务", "旅游", "足疗" ,"全部"};
        int[] imgs = new int[] { R.drawable.ic_category_0, R.drawable.ic_category_1,
                R.drawable.ic_category_2,R.drawable.ic_category_3,
                R.drawable.ic_category_4, R.drawable.ic_category_5,
                R.drawable.ic_category_6, R.drawable.ic_category_7,
                R.drawable.ic_category_8, R.drawable.ic_category_9,
                R.drawable.ic_category_10, R.drawable.ic_category_11,
                R.drawable.ic_category_12, R.drawable.ic_category_13,
                R.drawable.ic_category_14,R.drawable.ic_category_15};
        for(int i=page*8;i<(page+1)*8;i++){
            Caterory c = new Caterory();
            c.setName(category[i]);
            c.setImg(imgs[i]);
            gList.add(c);
        }

        return gList;
    }



}
