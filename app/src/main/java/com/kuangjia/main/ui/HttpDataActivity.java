package com.kuangjia.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kuangjia.main.Config;
import com.kuangjia.main.R;
import com.kuangjia.main.api.UserAPI;
import com.kuangjia.main.model.ErrorMessage;
import com.kuangjia.main.utils.DeviceUtils;
import com.kuangjia.main.utils.NetworkUtils;
import com.kuangjia.main.utils.RestAdapterUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;

public class HttpDataActivity extends AppCompatActivity {

    @Bind(R.id.txt_show1)
    TextView txt;
    @Bind(R.id.txt_show2)
    TextView mTxtShow2;
    UserAPI userAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_data);
        ButterKnife.bind(this);
        initView();
    }

    void initView() {
        userAPI = RestAdapterUtils.getRestAPI(Config.SJR_URL, UserAPI.class);
        userAPI.getInfo(new Callback<ErrorMessage>() {
            @Override
            public void success(ErrorMessage errorMessage, retrofit.client.Response response) {
                txt.setText(errorMessage.getErrorMessage().toString()
                        +"\n IpAddress："+DeviceUtils.getIPAddress()
                        +"\n 制造商："+DeviceUtils.getManufacturer()
                        +"\n 设备型号："+DeviceUtils.getDeviceModel()
                        +"\n NetWork："+ NetworkUtils.isNetworkAvaliable(HttpDataActivity.this));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
