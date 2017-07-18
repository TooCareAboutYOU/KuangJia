package com.cnlive.meplusd.kuangjia_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {

    View parent;


    @Bind(R.id.tv_test)
    TextView mTvTest;
    @Bind(R.id.btn_test2)
    Button mBtnTest2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        parent = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, parent);

        //initView();
        return parent;
    }

    private void initView() {
        mBtnTest2.setOnClickListener(this);
    }

    private void updateUI() {
        mBtnTest2.setOnClickListener(this);
        mTvTest.setText("第二碎片");
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onResume() {
        super.onResume();
        //当前是否显示状态
        if (isVisible()) {
            updateUI(); //刷新界面
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //当前是否显示状态
        if (isVisible() && isResumed()) {
            updateUI(); //刷新界面
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
