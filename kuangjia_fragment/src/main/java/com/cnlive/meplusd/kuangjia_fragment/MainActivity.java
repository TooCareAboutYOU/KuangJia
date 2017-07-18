package com.cnlive.meplusd.kuangjia_fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private MyDialogFragment dialogFragment;

    @Bind(R.id.btn_dialog_fragment)
    Button mBtnDialogFragment;
    @Bind(R.id.btn_show_fragment1)
    Button mBtnShowFragment1;
    @Bind(R.id.btn_show_fragment2)
    Button mBtnShowFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBtnDialogFragment.setOnClickListener(this);
        mBtnShowFragment1.setOnClickListener(this);
        mBtnShowFragment2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog_fragment:
                DialogView();
                break;
            case R.id.btn_show_fragment1:
                addView1();
                break;
            case R.id.btn_show_fragment2:
                addView2();
                break;
        }
    }

    protected void DialogView() {
        if (dialogFragment == null) {
            dialogFragment = MyDialogFragment.newInstance("大山的子孙呦！！！");
            dialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
            dialogFragment.show(getFragmentManager().beginTransaction(), "dialogFragment");
        }
    }

    private void addView1() {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        mTransaction.add(R.id.fl_group, firstFragment);
        mTransaction.commit();
    }

    private void addView2() {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        SecondFragment secondFragment = new SecondFragment();
        mTransaction.add(R.id.fl_group, secondFragment);
        mTransaction.commit();
    }

    protected void ToastInfo(String str) { Toast.makeText(this, str, Toast.LENGTH_SHORT).show(); }

    protected void refresh(String str) {  recreate(); ToastInfo(str); }


    @Override
    protected void onDestroy() { super.onDestroy(); ButterKnife.unbind(this); }
}
