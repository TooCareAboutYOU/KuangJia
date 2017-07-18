package com.kuangjia.main.kjapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.kuangjia.main.utils.DeviceUtils;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by zhangshuai on 2016-07-11.
 */
public class MyApplication extends Application {

    public static MyApplication instance;

    public static String ime="";

    @Override
    public void onCreate() {
        super.onCreate();

        instance=this;
        ImagePipelineConfig config= OkHttpImagePipelineConfigFactory.newBuilder(this,new OkHttpClient()).setDownsampleEnabled(true).build();
        Fresco.initialize(this,config);
        ime= DeviceUtils.getIEMI(this);

    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }

}
