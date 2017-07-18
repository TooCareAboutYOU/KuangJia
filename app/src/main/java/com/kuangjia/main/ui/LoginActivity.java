package com.kuangjia.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.kuangjia.main.R;
import com.kuangjia.main.cachedata.UserService;
import com.kuangjia.main.model.User;
import com.kuangjia.main.widget.BiuEditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.bt_name)
    BiuEditText mBtName;
    @Bind(R.id.bt_pwd)
    BiuEditText mBtPwd;
    @Bind(R.id.tv_info)
    TextView mTvInfo;

    User olduser, newUser;
    UserService mUSGet,mUSSet,mUSClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        olduser = new User();
        olduser.setUserName("admin");
        olduser.setUserName("123456");
    }

    void initData() {
        newUser = new User();
        if (!TextUtils.isEmpty(mBtName.getText().toString())) {
            newUser.setUserName(mBtName.getText().toString());
        }
        if (!TextUtils.isEmpty(mBtPwd.getText().toString())) {
            newUser.setUserPwd(mBtPwd.getText().toString());
        }
    }

    //保存用户信息
    void setUserInfo(View v) {
        initData();
        mUSGet = new UserService(this);
        mUSGet.updateUserInfo(olduser, newUser);
        mBtName.setText("");
        mBtPwd.setText("");
    }

    //读取用户信息
    void getUserInfo(View v) {
        mUSSet = new UserService(this);
        mTvInfo.setText("用户名："+mUSSet.getUserInfo().getUserName()+"\n 密码："+mUSSet.getUserInfo().getUserPwd());
    }

    //清空用户信息
    void clearUserInfo(View v){
        if (newUser != null) {
            mUSClear = new UserService(this);
            mUSClear.clserUserInfo(newUser);
            getUserInfo(v);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


}
